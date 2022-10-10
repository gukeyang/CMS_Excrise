package com.ujcmsitems.core.service;

import com.ujcmsitems.core.domain.Notice;
import com.ujcmsitems.utils.Response;

/**
 * @author a1002
 */
public interface NoticeService {
    /**
     * 添加/修改中心要闻或公告通知
     */
    Response addNotice(Notice notice);

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
