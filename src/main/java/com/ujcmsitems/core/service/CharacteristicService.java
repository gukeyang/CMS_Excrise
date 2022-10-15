package com.ujcmsitems.core.service;

import com.ujcmsitems.core.domain.Characteristic;
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
public interface CharacteristicService extends IService<Characteristic> {
    /**
     * add
     * @param characteristic
     * @return
     */
    R add(Characteristic characteristic);

    /**
     * delete
     * @param id
     * @return
     */
    R delete(Integer id);

    /**
     * deleteBatchIds
     * @param id
     * @return
     */
    R deleteBatchIds(Integer[] id);

    /**
     * pur
     * @param characteristic
     * @return
     */
    R put(Characteristic characteristic);
}
