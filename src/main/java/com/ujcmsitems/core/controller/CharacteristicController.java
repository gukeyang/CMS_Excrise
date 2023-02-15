package com.ujcmsitems.core.controller;


import com.ujcmsitems.core.domain.Characteristic;
import com.ujcmsitems.core.service.CharacteristicService;
import com.ujcmsitems.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xingchen
 * @since 2022-10-15
 */
@Controller
@CrossOrigin
@Api(tags = "特色平台库")
@RequestMapping("/administrator")
public class CharacteristicController {



    @Autowired
    private CharacteristicService characteristicService;




    @ApiOperation(value = "平台特色添加")
    @PostMapping(value = "/add")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "chTitle",value = "标题",required = true),
            @ApiImplicitParam(name = "chContent",value = "内容",required = true),
            @ApiImplicitParam(name = "firstTarget",value = "一级目录",required = true),
            @ApiImplicitParam(name = "secondTarget",value = "二级目录",required = true)
    })
    @ResponseBody
    public R add(String chTitle,String chContent,String firstTarget,String secondTarget){
        Characteristic characteristic=new Characteristic(chTitle,chContent,firstTarget,secondTarget);
        return characteristicService.add(characteristic);
    }

    /**
     * 平台特色删除
     * @param id
     * @return
     */
    @ApiOperation(value = "平台特色删除")
    @DeleteMapping(value = "/delete")
    @ResponseBody
    public R delete(Integer id){
        return characteristicService.delete(id);
    }

    /**
     * 平台特色批量删除
     * @param id
     * @return
     */
    @ApiOperation(value = "平台特色批量删除")
    @DeleteMapping(value = "/deleteBatchIds")
    @ResponseBody
    public R deleteBatchIds(Integer[] id){
        return characteristicService.deleteBatchIds(id);
    }


    @ApiOperation(value = "平台特色修改")
    @PutMapping(value = "/put")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id",required = true),
            @ApiImplicitParam(name = "chTitle",value = "标题",required = true),
            @ApiImplicitParam(name = "chContent",value = "内容",required = true),
            @ApiImplicitParam(name = "firstTarget",value = "一级目录",required = true),
            @ApiImplicitParam(name = "secondTarget",value = "二级目录",required = true)
    })
    @ResponseBody
    public R put(Integer id,String chTitle,String chContent,String firstTarget,String secondTarget){
        Characteristic characteristic=new Characteristic(id,chTitle,chContent,firstTarget,secondTarget);
        return characteristicService.put(characteristic);
    }


    /**
     * 平台特色展示
     * @return
     */
    @ApiOperation(value = "平台特色展示")
    @GetMapping(value = "/show")
    @ResponseBody
    public R show(){
        List<Characteristic> list = characteristicService.list();
        return new R(true,list,"平台特色展示");
    }





}
