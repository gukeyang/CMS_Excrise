package com.ujcmsitems.core.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ujcmsitems.core.domain.Notice;
import com.ujcmsitems.core.domain.partS;
import com.ujcmsitems.core.mapper.partSMapper;
import com.ujcmsitems.core.service.partSService;
import com.ujcmsitems.utils.Response;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @Author gukeyang
 */
@Service
public class partSServiceImpl extends ServiceImpl<partSMapper, partS> implements partSService {

    @Autowired
    private partSMapper partSMapper;

    @Override
    public Response addPartS(String name, String status) {
        partS partS = new partS(name,status);
        partSMapper.insert(partS);
        return Response.ok("添加成功");
    }

    @Override
    public Response updatePartS(Integer id, String name, String status) {
        partS partS = new partS(id,name,status);
        partSMapper.insert(partS);
        return Response.ok("修改成功");
    }

    @Override
    public Response deletePartS(Integer id) {
        partSMapper.deleteById(id);
        return Response.ok("删除成功");
    }

    @Override
    public Response findPartSByPages(int pages, int num) {
        return null;
    }

    @Override
    public Response findPartSById(Integer id) {
        partS partS = partSMapper.selectById(id);
        if (partS != null) {
            return Response.ok(partS);
        } else {
            return Response.error("不存在!");
        }
    }


}
