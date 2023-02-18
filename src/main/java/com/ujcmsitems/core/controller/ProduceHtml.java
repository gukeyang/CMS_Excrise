package com.ujcmsitems.core.controller;


import com.ujcmsitems.core.domain.Notice;
import com.ujcmsitems.core.service.NoticeService;
import com.ujcmsitems.utils.FreeMarkerUtil;
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
        model.addAttribute("notices",notices);        //根据模板生成静态html页面
        model.addAttribute("news",news);
        FreeMarkerUtil.processTemplate("index.ftl",model,"index.html");


        return "ok";
    }

//       FreeMarkerUtil.processTemplate("shipin.ftl",model,"shipin.html");
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

}
