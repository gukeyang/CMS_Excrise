package com.ujcmsitems.core.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ujcmsitems.core.domain.JwtResponse;
import com.ujcmsitems.core.domain.JwtUser;
import com.ujcmsitems.core.domain.Manager;
import com.ujcmsitems.core.mapper.ManagerMapper;
import com.ujcmsitems.core.service.ManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ujcmsitems.utils.JwtTokenUtil;
import com.ujcmsitems.utils.R;
import com.ujcmsitems.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xingchen
 * @since 2022-10-09
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {


    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;


    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Value("${jwt.header}")
    private String tokenHeader;

    Random random = new Random();

    @Override
    public JwtUser isLogin(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        //        JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(username);
        DecodedJWT decode = JWT.decode(token);
        Claim id = decode.getClaim("id");
        Claim account = decode.getClaim("admin");
        System.out.println(account);
        Claim password = decode.getClaim("password");
        Claim auth=decode.getClaim("authorities");
        return new JwtUser(id.asInt(),account.asString(),password.asString(),auth.asMap().get("authority").toString(),true);
    }

    @Override
    public R login(String admin, String password) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        Manager manager = managerMapper.selectOne(queryWrapper.eq("admin", admin).eq("password", password));
        if (manager == null){
            return new R(false, "密码错误");
        }
        String key="managerLimit";
        String managerKey="user@"+manager.getId();
        if(redisUtil.hasKey(key)&&redisUtil.sHasKey(key,"\""+managerKey+"\"")){
            return new R(false,"该用户已经被封禁");
        }
        try {
            authenticate(manager.getAdmin(),manager.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(manager.getAdmin());
        System.out.println(userDetails);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new R(true, ResponseEntity.ok(new JwtResponse(token)),"登录成功");
    }

    @Override
    public R register(String admin, String password) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        if(managerMapper.selectOne(queryWrapper.eq("admin",admin))!=null) {
            return new R(false, "该账号已经存在");
        }
        Random random=new Random(10);
        StringBuilder username=new StringBuilder("U平台");
        for (int i = 0; i < 6; i++) {
            int ran=random.nextInt(10);
            username.append(ran);
        }
        username.append("号");
        Manager manager=new Manager(admin,password);
        managerMapper.insert(manager);
        return new R(true, "账号添加成功");
    }

    void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    //退出登录
    @Override
    public void quit(HttpServletRequest request) {
        String token =request.getHeader("token");
        String userLimitKey="user@Limit:Token";
        String tokenKey="token@Limit"+token;
        redisUtil.sSetAndTime(userLimitKey,5 * 60 * 60,tokenKey);
    }

    //发送邮件
    @Override
    public R sendEmail(String email) {
        try {
            String key="email@limit:"+email;
            String emailKey="email:"+email+"@value";
//            if(redisUtil.hasKey(key)&&redisUtil.sHasKey(key,emailKey))
//                return new R(false,"该用户一分钟内已经发送过一次验证码");
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject("U平台");

            StringBuilder code = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int rand = random.nextInt(10);
                code.append(rand);
            }
            simpleMailMessage.setText("尊贵的U平台用户，您的验证码为：" + code + "，该验证码三分钟内有效，请勿泄露于他人");
            simpleMailMessage.setFrom(from);
            simpleMailMessage.setTo(email);
            mailSender.send(simpleMailMessage);
            String codeKey=email+":code";
            redisUtil.set(codeKey, code.toString(),180);
            redisUtil.sSetAndTime(key,60,emailKey);
            return new R(true,"发送成功");
        }
        catch (Exception e){
//            e.printStackTrace();
            return new R(false,"发送失败,请检查邮箱");
        }
    }

    //邮箱注册
    @Override
    @Transactional(rollbackFor = Exception.class)
    public R registerByEmail(String email, String userPassword, String code) {
        String codeKey=email+":code";
        Object value = redisUtil.get(codeKey);
        if(!code.equals(value)){
            return new R(false,"验证码错误");
        }
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        if(managerMapper.selectOne(queryWrapper.eq("admin",email))!=null){
            return new R(false,"该邮箱已经注册过账号");
        }if(managerMapper.selectOne(queryWrapper.eq("email",email))!=null){
            return new R(false,"该邮箱已经绑定过账号");
        }

        StringBuilder userName= new StringBuilder("U平台");
        for (int i=0;i<6;i++){
            int rand=random.nextInt(10);
            userName.append(rand);
        }
        userName.append("号");
        Manager manager=new Manager(email,userPassword,userName.toString(),email);
//        user.setUserHeadshotUrl("https://lmy-1311156074.cos.ap-nanjing.myqcloud.com/R-C.jpg");
        managerMapper.insert(manager);
        redisUtil.del(codeKey);
        return new R(true,"注册成功");
    }

    @Override
    public R loginByCode(String email, String code) {
        QueryWrapper<Manager> queryWrapper=new QueryWrapper<>();
        Manager manager = managerMapper.selectOne(queryWrapper.eq("email", email));
        if(manager==null){
            return new R(false,"该邮箱没有注册过账号");
        }
        if(manager.getUserAuthority()==1){
            return new R(false,"请检查账号");
        }
        String key="managerLimit";
        String managerKey="manager@"+manager.getId();
        if(redisUtil.hasKey(key)&&redisUtil.sHasKey(key,"\""+managerKey+"\"")){
            return new R(false,"该用户已经被封禁");
        }
        String codeKey=email+":code";
        Object value = redisUtil.get(codeKey);
        if(!code.equals(value)){
            return new R(false,"验证码错误");
        }
        try {
            authenticate(manager.getAdmin(),manager.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(manager.getAdmin());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new R(true,token,"登录成功");
    }


    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    @Override
    public Manager getUserByUserName(String username) {
        return managerMapper.selectOne(new QueryWrapper<Manager>().eq("username",username)
        .eq("enabled",true));
    }
}
