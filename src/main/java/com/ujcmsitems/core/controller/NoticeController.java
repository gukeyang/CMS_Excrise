package com.ujcmsitems.core.controller;

import com.ujcmsitems.core.service.NoticeService;
import com.ujcmsitems.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
     * 添加中心要闻或公告通知
     */
    @CacheEvict(value = "noticeCache", allEntries = true)
    @PostMapping("/addNotice")
    @ApiOperation(value = "添加中心要闻或公告通知")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "noticeTitle", value = "标题", required = true),
            @ApiImplicitParam(name = "noticeContent", value = "内容", required = true),
            @ApiImplicitParam(name = "firstTarget", value = "中心要闻/公告通知", required = true),
    })
    public Response addNotice(String noticeTitle, String noticeContent, String firstTarget) {
        return noticeService.addNotice(noticeTitle, noticeContent, firstTarget);
    }

    /**
     * 修改中心要闻或公告通知
     */
    @CacheEvict(value = "noticeCache", allEntries = true)
    @PutMapping("/updateNotice")
    @ApiOperation(value = "修改中心要闻或公告通知")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "所要修改的id       ", required = true),
            @ApiImplicitParam(name = "status", value = "文章审核状态", required = true),
            @ApiImplicitParam(name = "noticeTitle", value = "标题", required = true),
            @ApiImplicitParam(name = "noticeContent", value = "内容", required = true),
            @ApiImplicitParam(name = "firstTarget", value = "中心要闻/公告通知", required = true),
    })
    public Response updateNotice(int id, String noticeTitle, String noticeContent, int status, String firstTarget) {
        return noticeService.updateNotice(id, noticeTitle, noticeContent, status, firstTarget);
    }


    /**
     * 删除中心要闻或公告通知
     */
    @CacheEvict(value = "noticeCache", allEntries = true)
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
  //  @Cacheable(value = "noticeCache", key = "#id", unless = "#result==null")//返回结果等于空的话不缓存
    @GetMapping("/findNoticeById/{id}")
    @ApiOperation(value = "通过id查询中心要闻或公告通知")
    @ResponseBody
    @ApiImplicitParam(name = "id", value = "id", required = true)
    public Response findNoticeById(@PathVariable int id) {
        return noticeService.findNoticeById(id);
    }
}
