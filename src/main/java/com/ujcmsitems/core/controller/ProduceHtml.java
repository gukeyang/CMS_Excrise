package com.ujcmsitems.core.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ujcmsitems.core.domain.Notice;
import com.ujcmsitems.core.domain.Picture;
import com.ujcmsitems.core.service.CpictureService;
import com.ujcmsitems.core.service.NoticeService;
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
        model.addAttribute("notices",notices);        //根据模板生成静态html页面
        model.addAttribute("news",news);
        model.addAttribute("pictures",pictures);
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

    @ApiOperation(value = "更新公告")
    @RequestMapping("/updateNotice")
    private String updateNotice(Model model){

        //生成页面的UUID名称
        UUIDUtil util = new UUIDUtil();
        String s = UUIDUtil.getUUID() +".html";
        List<Notice> notices = noticeService.queryNoticeFour("中心要闻");
        Notice notice = notices.get(1);

        model.addAttribute("notice",notice);

        //生成模板页面
        FreeMarkerUtil.processTemplate("Notice.ftl",model,s);
        return "ok";
    }



}
