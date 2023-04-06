package com.ujcmsitems.core.controller;


import com.ujcmsitems.core.service.partMService;
import com.ujcmsitems.core.service.partSService;
import com.ujcmsitems.utils.R;
import com.ujcmsitems.utils.Response;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "区块设置")
@Controller
@CrossOrigin
@RequestMapping("/parts")
public class PartSController {

    @Resource
    private partSService partSService;

    /**
     * 区块的设置
     */

    @PostMapping("/savePartS")
    @ResponseBody
    //增添
    public R savePartS(String name, String status) {
        return new R(true,partSService.addPartS(name, status));
    }

    @GetMapping("/deletePartS")
    @ResponseBody
    //删除
    public R deletePartS(Long id){
        return new R(true,partSService.deletePartS(id));
    }

    @PutMapping("/updatePartS")
    @ResponseBody
    //修改
    public R updatePartS(Long id, String name, String status){
        return new R(true,partSService.updatePartS(id,name,status));
    }

    @GetMapping("/searchPartS")
    @ResponseBody
    //查询
    public R  searchPartS(Long id){
        return new R(true,partSService.findPartSById(id));
    }

}
