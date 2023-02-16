package com.ujcmsitems.core.service;

import com.ujcmsitems.core.dto.NoticeDto;
import com.ujcmsitems.utils.Response;

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
    Response updateNotice(int id, String noticeTitle, String noticeContent, int status, String firstTarget);

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
    Response findNoticeById(int id);
}
