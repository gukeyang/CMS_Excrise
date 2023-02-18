package com.ujcmsitems.core.controller;


import com.ujcmsitems.utils.FreeMarkerUtil;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * gukeyang
 * 生成静态页面的接口
 */
@Api(tags = "生成页面/更新页面")
@CrossOrigin
@Controller
public class ProduceHtml {

    /**
     * 生成静态页面的接口
     * @return
     */
    @ApiOperation(value = "全部更新页面")
    @RequestMapping("/produce")
    public void freeMarkerHtmlAll(Model model) {

        //根据模板生成静态html页面
        FreeMarkerUtil.processTemplate("index.ftl",model,"index.html");

        FreeMarkerUtil.processTemplate("shipin.ftl",model,"shipin.html");

        FreeMarkerUtil.processTemplate("shiti.ftl",model,"shiti.html");

        FreeMarkerUtil.processTemplate("xueyuan.ftl",model,"xueyuan.html");

        FreeMarkerUtil.processTemplate("xuni.ftl",model,"xuni.html");

        FreeMarkerUtil.processTemplate("yuancheng.ftl",model,"yuancheng.html");

        FreeMarkerUtil.processTemplate("zhongxin.ftl",model,"zhongxin.html");

    }

}
