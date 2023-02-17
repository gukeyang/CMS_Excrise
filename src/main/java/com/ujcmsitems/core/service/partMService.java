package com.ujcmsitems.core.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ujcmsitems.core.domain.partM;
import com.ujcmsitems.utils.Response;



/**
 * @Author gukeyang
 */


public interface partMService extends IService<partM> {

    /**
     * 添加
     */
    Response addPartM(String title, String picture, Long part);

    /**
     * 修改
     */
    Response updatePartM(Long id, String title, String picture, Long part);

    /**
     * 删除
     */
    String deletePartM(Long id);

    /**
     * 分页查询
     */
    Response findPartMByPages(int pages, int num);

    /**
     * 通过id查询
     */
    Response findPartMById(Long id);


}
