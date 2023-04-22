package com.ujcmsitems.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ujcmsitems.core.domain.Second;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xingchen
 * @since 2022-10-15
 */
public interface SecondService extends IService<Second> {

    boolean delete(Integer secondId);

    boolean deleteMore(Integer[] secondId);

    /**
     *
     * @param second
     * @return
     */
    boolean updateSecond(Second second);

    List<Second> getAllSecond(Integer firstId);

    IPage<Second> getPageSecond(Integer firstId, Integer currentPage, Integer pageSize);

    Set<String> getPageAllSecond();

    IPage<Second> searchPageSecond(Integer firstId, String search, Integer currentPage, Integer pageSize);

    List<Second> searchSecByLike(String secondTargetName);

}
