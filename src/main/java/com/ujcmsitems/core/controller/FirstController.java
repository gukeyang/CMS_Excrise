package com.ujcmsitems.core.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ujcmsitems.core.domain.First;
import com.ujcmsitems.core.service.FirstService;
import com.ujcmsitems.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
@Api(tags = "第一目录添加库")
@RequestMapping("/first")
public class FirstController {

    @Autowired
    private FirstService firstService;
    /**
     *
     * @return
     */
    @ApiOperation(value = "获取全部第一目录")
    @GetMapping(value = "/getAllFist")
    @ResponseBody
    public R getAllFist() {
        return new R(true,firstService.list(),"获取全部第一目录");
    }
    /**
     * 管理员添加第一目录
     * @param firstTargetName
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "管理员添加第一目录")
    @PostMapping(value = "/saveFirst")
    @ApiImplicitParam(name = "firstTargetName", value = "第一目录")
    @ResponseBody
    public R saveFirst(String firstTargetName) {
        return new R(true, firstService.saveFirst(firstTargetName));

    }


    /**
     * 管理员修改专业
     * @param first
     * @return
     */
    @ApiOperation(value = "管理员修改第一目录")
    @PutMapping(value = "/updateProfessional")
    @ResponseBody
    public R updateProfessional(First first) {
        boolean flag = firstService.modify(first);
        return new R(flag, flag ? "修改成功^_^" : "修改失败,专业已存在-_-!");
    }

    /**
     * 管理员删除专业
     *
     * @param firstId
     * @return
     */
    @ApiOperation(value = "管理员删除第一目录")
    @DeleteMapping(value = "/deleteProfessional")
    @ApiImplicitParam(name = "firstId", value = "id", required = true)
    @ResponseBody
    public R deleteProfessional(Integer firstId) {
        return new R(true, firstService.delete(firstId),"操作成功");
    }

    /**
     * 管理员对专业进行批量删除
     *
     * @param firstId
     * @return
     */
    @ApiOperation(value = "管理员对第一目录进行批量删除")
    @DeleteMapping(value = "/deleteMoreProfession")
    @ResponseBody
    public R deleteMoreProfession(Integer[] firstId) {
        return new R(true,firstService.deleteMore(firstId),"操作成功");
    }

    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/getPageProfessional")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页数", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页个数", required = true)
    })
    public R getPageProfessional(Integer currentPage, Integer pageSize) {
        IPage<First> page = firstService.getPageFirst(currentPage, pageSize);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = firstService.getPageFirst((int) page.getPages(), pageSize);
        }
        return new R(true, page);
    }


    /**
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @ApiOperation(value = "管理员模糊搜索第一目录")
    @GetMapping(value = "/searchProfession")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页数", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页个数", required = true),
            @ApiImplicitParam(name = "search", value = "搜索词", required = true)
    })
    @ResponseBody
    public R searchProfession(Integer currentPage, Integer pageSize, String search) {
        IPage<First> page = firstService.searchFirst(currentPage, pageSize, search);
        if (currentPage > page.getPages()) {
            page = firstService.searchFirst((int) page.getPages(), pageSize, search);
        }
        return new R(true, page);
    }



}
