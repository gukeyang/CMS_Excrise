package com.ujcmsitems.core.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ujcmsitems.core.domain.partS;
import com.ujcmsitems.utils.R;
import com.ujcmsitems.utils.Response;


/**
 * @Author gukeyang
 */


public interface partSService extends IService<partS> {

    /**
     * 添加区块
     * @param name
     * @param status
     * @return
     */
    Response addPartS(String name, String status);

    /**
     * 修改区块
     * @param id
     * @param name
     * @param status
     * @return
     */
    Response updatePartS(Long id, String name, String status);

    /**
     * 删除区块
     * @param id
     * @return
     */
    Response deletePartS(Long id);

    /**
     * 分页查询
     * @param page
     * @param num
     * @return
     */

    Response findPartSByPages(Integer page, Integer num);

    /**
     * 通过id查询区块
     * @param id
     * @return
     */

    Response findPartSById(Long id);
}
