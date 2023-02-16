package com.ujcmsitems.core.service;


import com.ujcmsitems.utils.Response;


/**
 * @Author gukeyang
 */


public interface partSService {

    /**
     * 添加
     */
    Response addPartS(String name, String status);

    /**
     * 修改
     */
    Response updatePartS(Integer id, String name, String status);

    /**
     * 删除
     */
    Response deletePartS(Integer id);

    /**
     * 分页查询
     */
    Response findPartSByPages(int pages, int num);

    /**
     * 通过id查询
     */
    Response findPartSById(Integer id);
}
