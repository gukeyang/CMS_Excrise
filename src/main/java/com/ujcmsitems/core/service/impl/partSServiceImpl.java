package com.ujcmsitems.core.service.impl;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ujcmsitems.core.domain.partS;
import com.ujcmsitems.core.mapper.partSMapper;
import com.ujcmsitems.core.service.partSService;
import com.ujcmsitems.utils.R;
import com.ujcmsitems.utils.Response;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author gukeyang
 */
@Service
public class partSServiceImpl extends ServiceImpl<partSMapper, partS> implements partSService {

    @Autowired
    private partSMapper partSMapper;
    @Autowired
    private partSService partSService;


    /**
     * 添加区快
     * @param name
     * @param status
     * @return
     */
    @Override
    public Response addPartS(String name, String status) {
        partS partS = new partS(name,status);
        partSMapper.insert(partS);
        return Response.ok("添加成功");
    }

    /**
     * 修改区块
     * @param id
     * @param name
     * @param status
     * @return
     */
    @Override
    public Response updatePartS(Long id, String name, String status) {
        partS partS = new partS(id,name,status);
        partSMapper.updateById(partS);
        return Response.ok("修改成功");
    }

    /**
     * 删除区块
     * @param id
     * @return
     */

    @Override
    public Response deletePartS(Long id) {
        partSMapper.deleteById(id);
        return Response.ok("删除成功");
    }

    /**
     * 分页查询区块
     * @param page
     * @param num
     * @return
     */
    @Override
    public Response findPartSByPages(Integer page, Integer num) {
        IPage pag = new Page(page,num);
        partSMapper.selectPage(pag, null);
        List<partS> partSList = pag.getRecords();
        if (partSList != null) {
            return Response.ok(partSList);
        }
        return Response.error("查询不到数据");
    }

    /**
     * 根据id查询区块
     * @param id
     * @return
     */
    @Override
    public Response findPartSById(Long id) {
        partS partS = partSMapper.selectById(id);
        if (partS != null) {
            return Response.ok(partS);
        } else {
            return Response.error("不存在!");
        }
    }


}
