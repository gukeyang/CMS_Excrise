package com.ujcmsitems.core.controller;



import com.ujcmsitems.core.domain.partMa;
import com.ujcmsitems.core.service.partMaService;
import com.ujcmsitems.utils.R;
import com.ujcmsitems.utils.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gu
 * @since 2022-10-15
 */
@Controller
@CrossOrigin
@Api(tags = "区块管理")
public class partManage {

    @Autowired
    private partMaService  partMaService;


    @ApiOperation(value = "获取全部的区块")
    @GetMapping(value = "/getList")
    @ResponseBody
    public R getList(){
        List<partMa> partMas = partMaService.queryAllPartMa();
        return  new R(true,partMas,"区块展示");
    }

    @ApiOperation(value = "删除指定id的区块")
    @DeleteMapping(value = "/deleteById")
    @ResponseBody
    public R deleteById(Integer id){
        return new R(true,partMaService.deletePartMaById(id),"删除区块");
    }

    @ApiOperation(value = "新增区块")
    @PostMapping(value = "/addPart")
    @ResponseBody
    public R  addPart(String name, String picture, Date date){
        return new R(true,partMaService.addPartMa(name,picture,date),"新增区块");
    }

    @ApiOperation(value = "查询区块")
    @GetMapping(value = "/queryPart")
    @ResponseBody
    public partMa queryPartByID(Integer id){
        return partMaService.queryPartByID(id);
    }

    @ApiOperation(value = "修改区块")
    @PutMapping(value = "/updatePart")
    @ResponseBody
    public partMa updatePart(int id){
        return partMaService.updatePartMa(id);
    }


}
