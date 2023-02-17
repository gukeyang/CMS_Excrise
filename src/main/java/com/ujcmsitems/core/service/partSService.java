package com.ujcmsitems.core.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ujcmsitems.core.domain.partS;
import com.ujcmsitems.utils.Response;


/**
 * @Author gukeyang
 */


public interface partSService extends IService<partS> {

    /**
     * 添加
     */
    Response addPartS(String name, String status);

    /**
     * 修改
     */
    Response updatePartS(Long id, String name, String status);

    /**
     * 删除
     */
    Response deletePartS(Long id);

    /**
     * 分页查询
     */
    Response findPartSByPages(int pages, int num);

    /**
     * 通过id查询
     */
    Response findPartSById(Long id);
}
