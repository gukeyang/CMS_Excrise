package com.ujcmsitems.core.controller;


import com.ujcmsitems.core.domain.*;
import com.ujcmsitems.core.service.*;
import com.ujcmsitems.utils.FreeMarkerUtil;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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


        //这个根据页面写死了
        String firstTarget  = "公告通知";
        String firstTarget1 = "中心要闻";
        String firstTarget2 = "在线测试";
        String firstTarget3 = "师生互动";
        List<Notice> notices = noticeService.queryNoticeFour(firstTarget);
        List<Notice> news = noticeService.queryNoticeFour(firstTarget1);
        List<Notice> ceshi = noticeService.queryNoticeFour(firstTarget2);
        List<Notice> hudong = noticeService.queryNoticeFour(firstTarget3);
        model.addAttribute("notices",notices);
        model.addAttribute("news",news);
        model.addAttribute("ceshi",ceshi);
        model.addAttribute("hudong",hudong);
        //也可以查询所有文章的信息，在前端判断类型，符合显示，不符合不显示
//        List<Notice> notices1 = noticeService.queryAllNotice();
//        model.addAttribute("notices1",notices1);


        //查询所有图片信息,并把它放在域中
        List<Picture> pictures = cpictureService.GetPictureinformation();
        model.addAttribute("pictures",pictures);


        //顶部的导航栏
        //查询全部的一级标题
        List<First> list = firstService.list();
        //放在addAttribute域中
        model.addAttribute("first",list);
        //获取second的全部信息 让first.id == firstID 相等，然后执行html下面的语句
        List<Second> secondList = secondService.getSecondList();
        //将查询到的second信息放在addAttribute域中
        model.addAttribute("secondList",secondList);
        //特色平台库
        List<Characteristic> lister = characteristicService.list();
        model.addAttribute("lister",lister);
        //生成页面
        FreeMarkerUtil.processTemplate("index.ftl",model,"index.html");
        return "更新成功";
    }

    @ApiOperation(value = "更新文章")
    @GetMapping("/updateNotice")
    private String updateNotice(Model model) throws NullPointerException{
//        //生成页面的UUID名称
//        UUIDUtil util = new UUIDUtil();
//        String s = UUIDUtil.getUUID() +".html";
//
        //----------------------------------------------------------------------------
        //暂时调用
        String firstTarget  = "公告通知";
        String firstTarget1 = "中心要闻";
        String firstTarget2 = "在线测试";
        String firstTarget3 = "师生互动";
        List<Notice> notices = noticeService.queryNoticeFour(firstTarget);
        List<Notice> news = noticeService.queryNoticeFour(firstTarget1);
        List<Notice> ceshi = noticeService.queryNoticeFour(firstTarget2);
        List<Notice> hudong = noticeService.queryNoticeFour(firstTarget3);
        model.addAttribute("notices",notices);        //根据模板生成静态html页面
        model.addAttribute("news",news);
        model.addAttribute("ceshi",ceshi);        //根据模板生成静态html页面
        model.addAttribute("hudong",hudong);


        List<Picture> pictures = cpictureService.GetPictureinformation();
        model.addAttribute("pictures",pictures);


        //顶部的导航栏

        //顶部的导航栏
        //查询全部的一级标题
        List<First> list = firstService.list();
        //放在addAttribute域中
        model.addAttribute("first",list);
        //获取second的全部信息 让first.id == firstID 相等，然后执行html下面的语句
        List<Second> secondList = secondService.getSecondList();
        //将查询到的second信息放在addAttribute域中
        model.addAttribute("secondList",secondList);

        List<Characteristic> lister = characteristicService.list();
        model.addAttribute("lister",lister);
//----------------------------------------------------------------------------
        for (int i = 1; i <= 70;i++){
            Notice data = noticeService.findNoticeById(i);
            if(data != null){
                System.out.println(data);
                if(data.getId() == i) {
                    String htmlUrl = data.getHtmlUrl();
                    String firstT = data.getFirstTarget();
                    List<Second> seconds = secondService.searchSecByLike(firstT);
                    if(seconds != null){
                        Second second = seconds.get(0);
                        Integer firstId = second.getFirstId();
                        List<Second> allSecond = secondService.getAllSecond(firstId);
                        model.addAttribute("allSecond",allSecond);
                    }
                    model.addAttribute("data", data);
                    FreeMarkerUtil.processTemplate("notice.ftl", model, "" + htmlUrl + "");
                    System.out.println(htmlUrl + " 更新完成");
                }
            }else{
                continue;
            }
        }
        return "更新成功";
    }

    @ApiOperation(value = "更新列表页")
    @GetMapping("/updateNoticeList")
    private String updateNoticeList(Model model) throws NullPointerException {

//----------------------------------------------------------------------------
        //暂时调用
        String firstTarget  = "公告通知";
        String firstTarget1 = "中心要闻";
        String firstTarget2 = "在线测试";
        String firstTarget3 = "师生互动";
        List<Notice> notices = noticeService.queryNoticeFour(firstTarget);
        List<Notice> news = noticeService.queryNoticeFour(firstTarget1);
        List<Notice> ceshi = noticeService.queryNoticeFour(firstTarget2);
        List<Notice> hudong = noticeService.queryNoticeFour(firstTarget3);
        model.addAttribute("notices",notices);        //根据模板生成静态html页面
        model.addAttribute("news",news);
        model.addAttribute("ceshi",ceshi);        //根据模板生成静态html页面
        model.addAttribute("hudong",hudong);


        List<Picture> pictures = cpictureService.GetPictureinformation();
        model.addAttribute("pictures",pictures);


        //顶部的导航栏
        //查询全部的一级标题
        List<First> list = firstService.list();
        //放在addAttribute域中
        model.addAttribute("first",list);
        //获取second的全部信息 让first.id == firstID 相等，然后执行html下面的语句
        List<Second> secondListT = secondService.getSecondList();
        //将查询到的second信息放在addAttribute域中
        model.addAttribute("secondListT",secondListT);


        List<Characteristic> lister = characteristicService.list();
        model.addAttribute("lister",lister);


        for (int j = 1; j <= 15; j++) {
            List<Second> allSecond = secondService.getAllSecond(j);
            if (allSecond.isEmpty()){
                continue;
            }else {
                model.addAttribute("allSecond",allSecond);
                int size = allSecond.size();
                List<Second> secondList = new ArrayList<Second>();
                for(int i = 0 ; i < size; i++){
                    Second second = allSecond.get(i);
                    secondList.add(second);
                }
                model.addAttribute("secondList",secondList);

                List<Notice> notices1 = noticeService.queryAllNotice();
                model.addAttribute("notices1",notices1);

                for(int i = 0 ; i < size; i++){
                    Second second = allSecond.get(i);
                    String url = second.getUrl();
                    String secondTargetName = second.getSecondTargetName();
                    model.addAttribute("currentTargetName",secondTargetName);
                    FreeMarkerUtil.processTemplate("noticeList.ftl", model,  ""+ url +"");
                    System.out.println("更新成功" + allSecond);
                    System.out.println("更新成功" + secondList);
                }

            }

        }
        return "更新成功";
    }
}
