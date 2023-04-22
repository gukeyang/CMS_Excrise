package com.ujcmsitems.core.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ujcmsitems.core.domain.*;
import com.ujcmsitems.core.service.*;
import com.ujcmsitems.utils.FreeMarkerUtil;
import com.ujcmsitems.utils.Response;
import com.ujcmsitems.utils.UUIDUtil;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;


import jline.internal.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
        List<First> list = firstService.list();
        //获取second的全部信息 让first.id == firstID 相等，然后执行html下面的语句
        List<Second> allSecond2 = secondService.getAllSecond(2);
        List<Second> allSecond3 = secondService.getAllSecond(3);
        List<Second> allSecond4 = secondService.getAllSecond(4);
        List<Second> allSecond5 = secondService.getAllSecond(5);
        List<Second> allSecond6=  secondService.getAllSecond(6);
        List<Second> allSecond7 = secondService.getAllSecond(7);
        List<Second> allSecond8 = secondService.getAllSecond(8);
        List<Second> allSecond9= secondService.getAllSecond(9);
        model.addAttribute("first",list);
        model.addAttribute("allSecond2",allSecond2);
        model.addAttribute("allSecond3",allSecond3);
        model.addAttribute("allSecond4",allSecond4);
        model.addAttribute("allSecond5",allSecond5);
        model.addAttribute("allSecond6",allSecond6);
        model.addAttribute("allSecond7",allSecond7);
        model.addAttribute("allSecond8",allSecond8);
        model.addAttribute("allSecond9",allSecond9);


        List<Characteristic> lister = characteristicService.list();
        model.addAttribute("lister",lister);


        FreeMarkerUtil.processTemplate("index.ftl",model,"index.html");
        return "ok";
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
        List<First> list = firstService.list();
        //获取second的全部信息 让first.id == firstID 相等，然后执行html下面的语句
        List<Second> allSecond2 = secondService.getAllSecond(2);
        List<Second> allSecond3 = secondService.getAllSecond(3);
        List<Second> allSecond4 = secondService.getAllSecond(4);
        List<Second> allSecond5 = secondService.getAllSecond(5);
        List<Second> allSecond6=  secondService.getAllSecond(6);
        List<Second> allSecond7 = secondService.getAllSecond(7);
        List<Second> allSecond8 = secondService.getAllSecond(8);
        List<Second> allSecond9= secondService.getAllSecond(9);
        model.addAttribute("first",list);
        model.addAttribute("allSecond2",allSecond2);
        model.addAttribute("allSecond3",allSecond3);
        model.addAttribute("allSecond4",allSecond4);
        model.addAttribute("allSecond5",allSecond5);
        model.addAttribute("allSecond6",allSecond6);
        model.addAttribute("allSecond7",allSecond7);
        model.addAttribute("allSecond8",allSecond8);
        model.addAttribute("allSecond9",allSecond9);


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
                    FreeMarkerUtil.processTemplate("notice1.ftl", model, "" + htmlUrl + "");
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
        List<First> list = firstService.list();
        //获取second的全部信息 让first.id == firstID 相等，然后执行html下面的语句
        List<Second> allSecond2 = secondService.getAllSecond(2);
        List<Second> allSecond3 = secondService.getAllSecond(3);
        List<Second> allSecond4 = secondService.getAllSecond(4);
        List<Second> allSecond5 = secondService.getAllSecond(5);
        List<Second> allSecond6=  secondService.getAllSecond(6);
        List<Second> allSecond7 = secondService.getAllSecond(7);
        List<Second> allSecond8 = secondService.getAllSecond(8);
        List<Second> allSecond9= secondService.getAllSecond(9);
        model.addAttribute("first",list);
        model.addAttribute("allSecond2",allSecond2);
        model.addAttribute("allSecond3",allSecond3);
        model.addAttribute("allSecond4",allSecond4);
        model.addAttribute("allSecond5",allSecond5);
        model.addAttribute("allSecond6",allSecond6);
        model.addAttribute("allSecond7",allSecond7);
        model.addAttribute("allSecond8",allSecond8);
        model.addAttribute("allSecond9",allSecond9);


        List<Characteristic> lister = characteristicService.list();
        model.addAttribute("lister",lister);
//----------------------------------------------------------------------------

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
