package com.ujcmsitems.core.controller;



import com.ujcmsitems.core.service.partSService;
import com.ujcmsitems.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
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
    @ApiOperation("添加区块")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "区块名称", required = true),
            @ApiImplicitParam(name = "status", value = "区块描述", required = true)
    })
    @ResponseBody
    //增添
    public R savePartS(String name, String status) {
        return new R(true,partSService.addPartS(name, status));
    }

    @DeleteMapping("/deletePartS")
    @ApiOperation("删除区块")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "区块名称", required = true),
            @ApiImplicitParam(name = "status", value = "区块描述", required = true)
    })
    @ResponseBody
    //删除
    public R deletePartS(Long id){
        return new R(true,partSService.deletePartS(id));
    }

    @PutMapping("/updatePartS")
    @ApiOperation("修改区块")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "区块名称", required = true),
            @ApiImplicitParam(name = "status", value = "区块描述", required = true)
    })
    @ResponseBody
    //修改
    public R updatePartS(Long id, String name, String status){
        return new R(true,partSService.updatePartS(id,name,status));
    }

    @GetMapping("/searchPartS")
    @ApiOperation("用id查询区块")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "区块名称", required = true),
            @ApiImplicitParam(name = "status", value = "区块描述", required = true)
    })
    @ResponseBody
    //查询
    public R  searchPartS(Long id){
        return new R(true,partSService.findPartSById(id));
    }

    @GetMapping("/findPartSByPages")
    @ApiOperation("分页查询区块")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pages", value = "当前页", required = true),
            @ApiImplicitParam(name = "num", value = "当前页数据量", required = true)
    })
    @ResponseBody
    //分页查询
    public R findPartSByPages(Integer pages, Integer num){
        return new R(true, partSService.findPartSByPages(pages, num));
    }

}
