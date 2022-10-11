package com.ujcmsitems.core.service.impl;

/**
 * @author Li
 * @Date 2022/7/23 1:09
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ujcmsitems.core.domain.JwtUser;
import com.ujcmsitems.core.domain.Manager;
import com.ujcmsitems.core.mapper.ManagerMapper;

import com.ujcmsitems.utils.JwtTokenUtil;
import com.ujcmsitems.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * JwtUserDetailsService
 *	 	实现UserDetailsService,重写loadUserByUsername方法
 *  	返回随机生成的user,pass是密码,这里固定生成的
 *  	如果你自己需要定制查询user的方法,请改造这里
 * @author zhengkai.blog.csdn.net
 */
@Service
public class JwtUserDetailsService implements UserDetailsService{
    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        QueryWrapper<Manager> queryWrapper=new QueryWrapper<>();
        Manager manager = managerMapper.selectOne(queryWrapper.eq("admin",username));
        if(manager!=null){
            return new JwtUser(manager.getId(), username,manager.getPassword(), String.valueOf(manager.getUserAuthority()), true);
        }
        else {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
    }

}


