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
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 前端控制器
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

    /**
     * 账号注册
     *
     * @param admin
     * @param password
     * @return
     */
    @ApiOperation(value = "账号注册")
    @PostMapping(value = "/register")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "admin", value = "账号", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    @ResponseBody
    public R register(String admin, String password) {
        return managerService.register(admin, password);
    }

    /**
     * 发送邮件
     *
     * @param email
     * @return
     */
    @ApiOperation(value = "发送邮件")
    @PostMapping(value = "/sendEmail")
    @ResponseBody
    public R sendEmail(String email) {
        return managerService.sendEmail(email);
    }


    /**
     * 邮箱号注册
     *
     * @param email        邮箱
     * @param userPassword 密码
     * @param code         验证码
     * @return com.xingchen.utils.R
     * @date 2022/7/1 22:20
     */
    @ApiOperation(value = "邮箱号注册")
    @PostMapping(value = "/registerByEmail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "邮箱", required = true),
            @ApiImplicitParam(name = "userPassword", value = "密码", required = true),
            @ApiImplicitParam(name = "code", value = "验证码", required = true)
    })
    @ResponseBody
    public R registerByEmail(String email, String userPassword, String code) {
        return managerService.registerByEmail(email, userPassword, code);
    }


    /**
     * 用户密码登录
     *
     * @param admin
     * @param password
     * @return
     */
    @ApiOperation(value = "用户密码登录")
    @PostMapping(value = "/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "admin", value = "账号", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    @ResponseBody
    public R login(String admin, String password) {
        return managerService.login(admin, password);
    }


    /**
     * 验证码登录
     *
     * @param email 邮箱
     * @param code  验证码
     * @return com.xingchen.utils.R
     * @date 2022/7/2 20:05
     */
    @ApiOperation(value = "用户验证码登录")
    @PostMapping(value = "/loginByCode")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "邮箱", required = true),
            @ApiImplicitParam(name = "code", value = "验证码", required = true)
    })
    @ResponseBody
    public R loginByCode(String email, String code) {
        return managerService.loginByCode(email, code);
    }


    /**
     * 判断登录
     *
     * @return com.xingchen.utils.R
     * @date 2022/7/5 21:31
     */
    @ApiOperation(value = "判断登录")
    @GetMapping(value = "/isLogin")
    @ResponseBody
    public JwtUser isLogin(HttpServletRequest request) {
        return managerService.isLogin(request);
    }


    /**
     * 注销用户
     */
    @ApiOperation(value = "注销用户")
    @ResponseBody
    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
        System.out.println("logout执行了...");
    }


    /**
     * 修改账户信息
     *
     * @param id
     * @param username
     * @return
     */
    @ApiOperation(value = "修改账户信息")
    @PutMapping(value = "/all/update")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
            @ApiImplicitParam(name = "username", value = "昵称")
    })
    @ResponseBody
    public R update(Integer id, String username) {
        return managerService.change(id, username);
    }
}


