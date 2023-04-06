//package com.ujcmsitems.core.controller;
//
//
//import com.ujcmsitems.core.domain.Manager;
//import com.ujcmsitems.core.service.ManagerService;
//import com.ujcmsitems.utils.RespBean;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import java.security.Principal;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//
//@Controller
//@CrossOrigin
//@Api(tags = "获取当前用户信息")
//public class RequestUser {
//
//    @ApiOperation(value = "获取当前的ip地址")
//    @RequestMapping(value = "/ip", method = RequestMethod.GET)
//    @ResponseBody
//    public static String currentIp(HttpServletRequest request) {
//        String localAddr = request.getLocalAddr();
//        int serverPort = request.getServerPort();
//        return localAddr;
//    }
//
//
//    @ApiOperation(value = "获取现在时间")
//    @RequestMapping(value = "/date", method = RequestMethod.GET)
//    @ResponseBody
//    public String currentDate() {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
//        Date date = new Date(System.currentTimeMillis());
//        String format = formatter.format(date);
//        System.out.println(formatter.format(date));
//        return format;
//    }
//
//
//    @ApiOperation(value = "退出登录")
//    @PostMapping("/logout")
//    @ResponseBody
//    public RespBean logout() {
//        return RespBean.success("注销成功！");
//    }
//
//
//
//}
