package com.ujcmsitems.core.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ujcmsitems.core.domain.Second;
import com.ujcmsitems.core.service.SecondService;
import com.ujcmsitems.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

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
@Api(tags = "第二目录添加库")
public class SecondController {

    @Autowired
    private SecondService secondService;


    boolean flag=true;

    /**
     * 管理员添加专业下的学科
     * @param firstId
     * @param secondTargetName
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "管理员添加第一目录下的第二目录")
    @PostMapping(value = "/saveSecond")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "firstId",value = "第一目录id",required = true),
            @ApiImplicitParam(name = "secondTargetName",value = "第二目录名字"),
    })
    @ResponseBody
    public R saveSecond(Integer firstId,String secondTargetName) throws IOException {
        Second second=new Second(firstId,secondTargetName);
        QueryWrapper<Second> courseQueryWrapper=new QueryWrapper<>();
        courseQueryWrapper.eq("first_id",firstId);
        courseQueryWrapper.eq("second_target_name", secondTargetName);
        List<Second> seconds = secondService.list(courseQueryWrapper);
        if(seconds.isEmpty()){
            boolean flag = secondService.save(second);
            return new R(flag, flag ? "添加成功^_^" : "添加失败,该第一目录下的第二目录已存在-_-!");
        }
        return new R(flag, flag ? "添加成功^_^" : "添加失败,该第一目录下的第二目录已存在-_-!");
    }


    /**
     * 管理员删除第一目录下的第二目录
     * @param secondId
     * @return
     */
    @ApiOperation(value = "管理员删除第一目录下的第二目录")
    @DeleteMapping(value = "/deleteSecond")
    @ApiImplicitParam(name = "secondId",value = "第二目录",required = true)
    @ResponseBody
    public R deleteSecond(Integer secondId){
        return new R(true,secondService.delete(secondId),"操作成功");
    }

    /**
     * 管理员对第一目录下的第二目录进行批量删除
     * @param secondId
     * @return
     */
    @ApiOperation(value = "管理员对第一目录下的第二目录进行批量删除")
    @DeleteMapping(value = "/deleteMoreCourse")
    @ResponseBody
    public R deleteMoreSecond(Integer[] secondId){
        return new R(true,secondService.deleteMore(secondId),"操作成功");
    }



    /**
     * 管理员修改第一目录下的第二目录
     * @param second
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "管理员修改第一目录下的第二目录")
    @PutMapping(value = "/updateProfessionalCourse")
    @ResponseBody
    public R updateSecond(Second second) {
        boolean flag = secondService.updateSecond(second);
        return new R(flag, flag ? "修改成功^_^" : "修改失败,该专业下学科已存在-_-!");
    }



    /**
     * 查询第一目录下的所有第二目录
     * @param firstId
     * @return
     */
    @ApiOperation(value = "查询第一目录下的所有第二目录")
    @PostMapping(value = "/getAllSecond")
    @ApiImplicitParam(name = "firstId",value = "第一目录的id",required = true)
    @ResponseBody
    public R getAllSecond(Integer firstId){
        List<Second> seconds = secondService.getAllSecond(firstId);
        if(seconds.isEmpty()){
            flag=false;
        }
        return new R(flag,seconds);
    }


    /**
     *
     * @param firstId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页查询第一目录下的所有第二目录")
    @GetMapping(value = "/getPageSecond")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage",value = "当前页数",required = true),
            @ApiImplicitParam(name = "firstId",value = "第一目录的id",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页个数",required = true)
    })
    @ResponseBody
    public R getPageSecond(Integer firstId,Integer currentPage,Integer pageSize) {
        IPage<Second> page = secondService.getPageSecond(firstId,currentPage, pageSize);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = secondService.getPageSecond(firstId,(int) page.getPages(), pageSize);
        }
        return new R(true, page);
    }

    /**
     * 分页查询所有的学科
     * @return
     */
    @ApiOperation(value = "分页查询所有的第二目录")
    @GetMapping(value = "/getPageAllCourse")
    @ResponseBody
    public R getPageAllSecond() {
        Set<String> pageAllSecond = secondService.getPageAllSecond();
        return new R(true, pageAllSecond);
    }


    /**
     * 分页搜索第一目录下的所有第二目录
     * @param firstId
     * @param search
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页搜索第一目录下的所有第二目录")
    @GetMapping(value = "/SearchSecond")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage",value = "当前页数",required = true),
            @ApiImplicitParam(name = "firstId",value = "第一目录的id",required = true),
            @ApiImplicitParam(name = "search",value = "第二目录名字",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页个数",required = true)
    })
    @ResponseBody
    public R SearchSecond(Integer firstId,String search,Integer currentPage,Integer pageSize) {
        IPage<Second> page =secondService.searchPageSecond(firstId,search,currentPage, pageSize);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = secondService.searchPageSecond(firstId,search,(int) page.getPages(), pageSize);
        }
        return new R(true, page);
    }
}
