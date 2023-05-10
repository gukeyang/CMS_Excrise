package com.ujcmsitems.core.service;

import com.ujcmsitems.core.domain.Notice;
import com.ujcmsitems.core.dto.NoticeDto;
import com.ujcmsitems.utils.Response;

import java.util.List;

/**
 * @author a1002
 */
public interface NoticeService {
    /**
     * 添加中心要闻或公告通知
     */
    Response addNotice(NoticeDto noticeDto);

    /**
     * 修改中心要闻或公告通知
     */
    Response updateNotice(Integer id, String noticeTitle, String noticeContent, Integer status, String firstTarget,String htmlUrl);

    /**
     * 删除中心要闻或公告通知
     */
    Response deleteNotice(int id);

    /**
     * 分页查询中心要闻或公告通知
     */
    Response findNoticeByPages(int pages, int num);

    /**
     * 通过id查询中心要闻或公告通知
     */
    Notice findNoticeById(int id);

    /**
     * 获取后八条数据
     */

    List<Notice> queryNoticeFour(String firstTarget);

    /**
     *获取全部的数据
     * @return
     */
    List<Notice> queryAllNotice();
}
