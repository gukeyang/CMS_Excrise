package com.ujcmsitems.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ujcmsitems.core.domain.Characteristic;
import com.ujcmsitems.core.mapper.CharacteristicMapper;
import com.ujcmsitems.core.service.CharacteristicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ujcmsitems.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xingchen
 * @since 2022-10-15
 */
@Service
public class CharacteristicServiceImpl extends ServiceImpl<CharacteristicMapper, Characteristic> implements CharacteristicService {

    @Autowired
    private CharacteristicMapper characteristicMapper;


    @Override
    public R add(Characteristic characteristic) {
        if(StringUtils.isEmpty(characteristic.getChTitle())
                ||StringUtils.isEmpty(characteristic.getChContent())
                ||StringUtils.isEmpty(characteristic.getFirstTarget())
                ||StringUtils.isEmpty(characteristic.getSecondTarget())
        ){
            return new R(false,0,"数据错误添加失败");
        }
        characteristicMapper.insert(characteristic);
        return new R(true,1,"数据添加成功");

    }

    @Override
    public R delete(Integer id) {
        QueryWrapper<Characteristic> queryWrapper=new QueryWrapper<>();
        Characteristic characteristic = characteristicMapper.selectOne(queryWrapper.eq("id", id));
        if(characteristic==null){
            return new R(false,0,"该内容不存在,无法删除");
        }
        characteristicMapper.deleteById(id);
        return new R(true,characteristic.getChTitle(),"数据删除成功");
    }

    /**
     * deleteBatchIds
     *
     * @param id
     * @return
     */
    @Override
    public R deleteBatchIds(Integer[] id) {
        int i = characteristicMapper.deleteBatchIds(Arrays.asList(id));
        if(i==0){
            return new R(false,0,"该内容不存在,无法删除");
        }
        return new R(true,1,"数据删除成功");
    }

    /**
     * pur
     *
     * @param characteristic
     * @return
     */
    @Override
    public R put(Characteristic characteristic) {
        QueryWrapper<Characteristic> queryWrapper=new QueryWrapper<>();
        Characteristic characteristic1 = characteristicMapper.selectOne(queryWrapper.eq("id", characteristic.getId()));
        if(characteristic1==null){
            return new R(false,0,"该内容不存在,无法修改");
        }
        return new R(true,1,"数据修改成功");
    }
}
