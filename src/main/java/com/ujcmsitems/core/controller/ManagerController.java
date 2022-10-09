package com.ujcmsitems.core.controller;


import com.ujcmsitems.core.domain.JwtUser;
import com.ujcmsitems.core.service.ManagerService;
import com.ujcmsitems.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xingchen
 * @since 2022-10-09
 */
@Controller
@CrossOrigin
@Api(tags = "账号")
public class ManagerController {

    @Autowired
    private ManagerService managerService;


    @ApiOperation(value = "账号注册")
    @PostMapping(value = "/register")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "admin",value = "账号",required = true),
            @ApiImplicitParam(name = "password",value = "密码",required = true)
    })
    @ResponseBody
    public R register(String admin, String password){
        return managerService.register(admin,password);
    }




    @ApiOperation(value = "用户密码登录")
    @PostMapping(value = "/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "admin",value = "账号",required = true),
            @ApiImplicitParam(name = "password",value = "密码",required = true)
    })
    @ResponseBody
    public R login(String admin, String password){
        return managerService.login(admin,password);
    }


    /**
     *判断登录
     * @date 2022/7/5 21:31
     * @return com.xingchen.utils.R
     */
    @ApiOperation(value = "判断登录")
    @GetMapping(value = "/isLogin")
    @ResponseBody
    public JwtUser isLogin(HttpServletRequest request){
        return managerService.isLogin(request);
    }

}


