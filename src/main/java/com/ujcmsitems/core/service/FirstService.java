package com.ujcmsitems.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ujcmsitems.core.domain.First;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ujcmsitems.utils.R;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xingchen
 * @since 2022-10-15
 */
public interface FirstService extends IService<First> {


    boolean modify(First first);

    boolean delete(Integer firstId);

    /**
     *deleteMore
     * @param firstId
     * @return
     */
    boolean deleteMore(Integer[] firstId);

    /**
     * getPageFirst
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<First> getPageFirst(Integer currentPage, Integer pageSize);

    /**
     * searchFirst
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    IPage<First> searchFirst(Integer currentPage, Integer pageSize, String search);

    R saveFirst(String firstTargetName);
}
