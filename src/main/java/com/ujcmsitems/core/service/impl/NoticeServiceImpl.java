package com.ujcmsitems.core.service.impl;

import com.ujcmsitems.core.Repository.NoticeRepository;
import com.ujcmsitems.core.domain.Notice;
import com.ujcmsitems.core.service.NoticeService;
import com.ujcmsitems.utils.Response;
import com.ujcmsitems.utils.YangUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author a1002
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeRepository noticeRepository;

    @Override
    public Response addNotice(Notice notice) {
        noticeRepository.save(notice);
        return Response.ok("添加成功！");
    }

    @Override
    public Response deleteNotice(int id) {
        noticeRepository.deleteById(id);
        return Response.ok("删除成功！");
    }

    @Override
    public Response findNoticeByPages(int pages, int num) {
        List<Notice> list = noticeRepository.findAll();
        return Response.ok(YangUtils.queryPages(list, pages, num));
    }

    @Override
    public Response findNoticeById(int id) {
        Notice notice = noticeRepository.findById(id).orElse(null);
        if (notice != null) {
            return Response.ok(notice);
        } else {
            return Response.error("不存在此notice！");
        }
    }
}
