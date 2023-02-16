package com.ujcmsitems.core.controller;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ujcmsitems.core.domain.First;
import com.ujcmsitems.core.domain.partM;
import com.ujcmsitems.core.service.partMService;
import com.ujcmsitems.core.service.partSService;
import com.ujcmsitems.utils.R;
import io.swagger.annotations.Api;

import io.swagger.models.auth.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "区块管理和设置")
@Controller
@CrossOrigin
@RequestMapping("/toPart")
public class partController {


    @Resource
    private partMService partMservice;
    @Resource
    private partSService partSService;


    /**
     * 区块的管理
     */

    @PostMapping("/savePartM")
    //增添
    public R savePartM(String title, String picture, Integer part) {
        return new R(true,partMservice.addPartM(title, picture, part));
    }

    @GetMapping("/deletePartM")
    //删除
    public R deletePartM(Integer id){
        return new R(true,partMservice.deletePartM(id));
    }

    @PutMapping("/updatePartM")
    //修改
    public R updatePartM(Integer id, String title, String picture, Integer part){
        return new R(true,partMservice.updatePartM(id,title,picture,part));
    }

    @GetMapping("/searchPartM")
    //查询
    public R  searchPartM(Integer id){
        return new R(true,partMservice.findPartMById(id));
    }

    /**
     * 区块的设置
     */

    @PostMapping("/savePartS")
    //增添
    public R savePartS(String name, String status) {
        return new R(true,partSService.addPartS(name, status));
    }

    @GetMapping("/deletePartS")
    //删除
    public R deletePartS(Integer id){
        return new R(true,partSService.deletePartS(id));
    }

    @PutMapping("/updatePartS")
    //修改
    public R updatePartS(Integer id, String name, String status){
        return new R(true,partSService.updatePartS(id,name,status));
    }

    @GetMapping("/searchPartS")
    //查询
    public R  searchPartS(Integer id){
        return new R(true,partSService.findPartSById(id));
    }

}
