package com.ujcmsitems.core.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ujcmsitems.core.domain.*;
import com.ujcmsitems.core.service.*;
import com.ujcmsitems.utils.FreeMarkerUtil;
import com.ujcmsitems.utils.UUIDUtil;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * gukeyang
 * 生成静态页面的接口
 * @author
 */
@Api(tags = "生成页面/更新页面")
@CrossOrigin
@RestController
@RequestMapping("/ProduceHtml")
public class ProduceHtml {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private CpictureService cpictureService;

    @Autowired
    private FirstService firstService;

    @Autowired
    private SecondService secondService;

    @Autowired
    private CharacteristicService characteristicService;
    /**
     * 生成静态页面的接口
     * @return
     */
    @ApiOperation(value = "更新首页")
    @GetMapping("/updateIndex")
    public String updateIndex(Model model) {

        FreeMarkerUtil.processTemplate("index.ftl",model,"index.html");

        return "ok";
    }

}
