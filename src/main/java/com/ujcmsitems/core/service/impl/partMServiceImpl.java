package com.ujcmsitems.core.service.impl;


import com.ujcmsitems.core.domain.Notice;
import com.ujcmsitems.core.domain.partM;
import com.ujcmsitems.core.domain.partS;
import com.ujcmsitems.core.mapper.partMMapper;
import com.ujcmsitems.core.service.partMService;

import com.ujcmsitems.utils.Response;
import org.springframework.stereotype.Service;

/**
 * @Author gukeyang
 */
@Service
public class partMServiceImpl  implements partMService {

    private partMMapper partMMapper;

    @Override
    public Response addPartM(String title, String picture, Integer part) {

        partM partM = new partM(title,picture,part);
        partMMapper.insert(partM);
        return Response.ok("添加成功");
    }

    @Override
    public Response updatePartM(Integer id, String title, String picture, Integer part) {
        partM partM = new partM(id,title,picture,part);
        partMMapper.insert(partM);
        return Response.ok("更新成功");
    }

    @Override
    public Response deletePartM(Integer id) {
        partMMapper.deleteById(id);
        return Response.ok("删除成功");
    }

    @Override
    public Response findPartMByPages(int pages, int num) {
        return null;
    }

    @Override
    public Response findPartMById(Integer id) {
        partM partM = partMMapper.selectById(id);
        if (partM != null) {
            return Response.ok(partM);
        } else {
            return Response.error("不存在！");
        }
    }
}
