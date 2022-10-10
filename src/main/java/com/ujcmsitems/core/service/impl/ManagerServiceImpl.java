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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

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
    private RedisUtil redisUtil;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Value("${jwt.header}")
    private String tokenHeader;

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
}
