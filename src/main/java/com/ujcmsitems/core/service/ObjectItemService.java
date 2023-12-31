package com.ujcmsitems.core.service;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ujcmsitems.core.domain.First;
import com.ujcmsitems.core.domain.ObjectItem;
import com.ujcmsitems.utils.Response;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author a1002
 */
public interface ObjectItemService extends IService<ObjectItem> {

    void removeByPath(List<String> objectName);

    void removeByHtitle(String htitle);

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<ObjectItem> getPageObject(Integer currentPage, Integer pageSize);


    /**
     * 分页模糊查询
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    IPage<ObjectItem> getPageObjectLike(Integer currentPage, Integer pageSize,String search);


    /**
     *模糊查询
     * @param htitle
     * @return
     */
    List<ObjectItem> searchByLike(String htitle);

    /**
     * id
     * 查询
     * @param id
     * @return
     */

    public ObjectItem getObjectItemsById(Long id);
}
