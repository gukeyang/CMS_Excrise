package com.ujcmsitems.core.service;


import com.ujcmsitems.utils.Response;



/**
 * @Author gukeyang
 */


public interface partMService {

    /**
     * 添加
     */
    Response addPartM(String title, String picture, Integer part);

    /**
     * 修改
     */
    Response updatePartM(Integer id, String title, String picture, Integer part);

    /**
     * 删除
     */
    Response deletePartM(Integer id);

    /**
     * 分页查询
     */
    Response findPartMByPages(int pages, int num);

    /**
     * 通过id查询
     */
    Response findPartMById(Integer id);


}
