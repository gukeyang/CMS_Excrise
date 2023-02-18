package com.ujcmsitems.core.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ujcmsitems.core.domain.partM;
import com.ujcmsitems.core.mapper.partMMapper;
import com.ujcmsitems.core.service.partMService;

import com.ujcmsitems.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author gukeyang
 */
@Service
@Slf4j
public class partMServiceImpl  extends ServiceImpl<partMMapper, partM>  implements partMService {

    @Resource
    private partMMapper partMMapper;

    @Override
    public Response addPartM(String title, String picture, Long part) {


        partM partM = new partM(title,picture,part);
        partMMapper.insert(partM);
        return Response.ok("success!");
    }

    @Override
    public Response updatePartM(Long id, String title, String picture, Long part) {
        partM partM = new partM(id,title,picture,part);
        partMMapper.insert(partM);
        return Response.ok("更新成功");
    }

    @Override
    public String deletePartM(Long id) {
        partMMapper.deleteById(id);
        return "SUCCESS!";
    }

    @Override
    public Response findPartMByPages(int pages, int num) {
        return null;
    }

    @Override
    public Response findPartMById(Long id) {
        partM partM = partMMapper.selectById(id);
        if (partM != null) {
            return Response.ok(partM);
        } else {
            return Response.error("不存在！");
        }
    }
}
