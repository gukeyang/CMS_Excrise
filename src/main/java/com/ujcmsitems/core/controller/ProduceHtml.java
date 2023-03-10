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
    @RequestMapping("/updateIndex")
    public String updateIndex(Model model) {


        String firstTarget  = "公告通知";
        String firstTarget1 = "中心要闻";

        List<Notice> notices = noticeService.queryNoticeFour(firstTarget);
        List<Notice> news = noticeService.queryNoticeFour(firstTarget1);
        List<Picture> pictures = cpictureService.GetPictureinformation();

        //顶部的导航栏
        List<First> list = firstService.list();
        List<Second> allSecond2 = secondService.getAllSecond(2);
        List<Second> allSecond3 = secondService.getAllSecond(3);
        List<Second> allSecond4 = secondService.getAllSecond(4);
        List<Second> allSecond5 = secondService.getAllSecond(5);
        List<Second> allSecond6=  secondService.getAllSecond(6);
        List<Second> allSecond7 = secondService.getAllSecond(7);
        model.addAttribute("first",list);
        model.addAttribute("allSecond2",allSecond2);
        model.addAttribute("allSecond3",allSecond3);
        model.addAttribute("allSecond4",allSecond4);
        model.addAttribute("allSecond5",allSecond5);
        model.addAttribute("allSecond6",allSecond6);
        model.addAttribute("allSecond7",allSecond7);


        model.addAttribute("notices",notices);        //根据模板生成静态html页面
        model.addAttribute("news",news);
        model.addAttribute("pictures",pictures);


        List<Characteristic> lister = characteristicService.list();
        model.addAttribute("lister",lister);


        FreeMarkerUtil.processTemplate("index.ftl",model,"index.html");
//----------------------------------------------------------------------------------------------------
//        FreeMarkerUtil.processTemplate("shipin.ftl",model,"shipin.html");
//
//        FreeMarkerUtil.processTemplate("shiti.ftl",model,"shiti.html");
//
//        FreeMarkerUtil.processTemplate("xueyuan.ftl",model,"xueyuan.html");
//
//        FreeMarkerUtil.processTemplate("xuni.ftl",model,"xuni.html");
//
//        FreeMarkerUtil.processTemplate("yuancheng.ftl",model,"yuancheng.html");
//
//        FreeMarkerUtil.processTemplate("zhongxin.ftl",model,"zhongxin.html");
        return "ok";
    }

//    @ApiOperation(value = "更新公告")
//    @RequestMapping("/updateNotice")
//    private String updateNotice(Model model){
//
//        //生成页面的UUID名称
//        UUIDUtil util = new UUIDUtil();
//        String s = UUIDUtil.getUUID() +".html";
//        List<Notice> notices = noticeService.queryNoticeFour("中心要闻");
//        Notice notice = notices.get(1);
//
//        model.addAttribute("notice",notice);
//
//        //生成模板页面
//        FreeMarkerUtil.processTemplate("Notice.ftl",model,s);
//        return "ok";
//    }



}
