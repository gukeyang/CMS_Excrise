package com.ujcmsitems.core.controller;

import com.ujcmsitems.core.domain.Notice;
import com.ujcmsitems.core.service.NoticeService;
import com.ujcmsitems.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author a1002
 */

@Api(tags = "中心要闻/公告通知")
@RestController
@RequestMapping("/administrator")
public class NoticeController {
    @Resource
    private NoticeService noticeService;

    /**
     * 添加/修改中心要闻或公告通知
     */
    @PostMapping("/addNotice")
    @ApiOperation(value = "添加/修改中心要闻或公告通知")
    @ResponseBody
    public Response addNotice(Notice notice) {
        return noticeService.addNotice(notice);
    }


    /**
     * 删除中心要闻或公告通知
     */
    @DeleteMapping("/deleteNotice/{id}")
    @ApiOperation(value = "删除中心要闻或公告通知")
    @ResponseBody
    @ApiImplicitParam(name = "id", value = "id", required = true)
    public Response deleteNotice(@PathVariable int id) {
        return noticeService.deleteNotice(id);
    }

    /**
     * 分页查询中心要闻或公告通知
     */
    @GetMapping("/findNoticeByPages")
    @ApiOperation(value = "分页查询中心要闻或公告通知")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pages", value = "第几页", required = true),
            @ApiImplicitParam(name = "num", value = "查询数量", required = true),
    })
    public Response findNoticeByPages(int pages, int num) {
        return noticeService.findNoticeByPages(pages, num);
    }

    /**
     * 通过id查询中心要闻或公告通知
     */
    @GetMapping("/findNoticeById/{id}")
    @ApiOperation(value = "通过id查询中心要闻或公告通知")
    @ResponseBody
    @ApiImplicitParam(name = "id", value = "id", required = true)
    public Response findNoticeById(@PathVariable int id) {
        return noticeService.findNoticeById(id);
    }
}
