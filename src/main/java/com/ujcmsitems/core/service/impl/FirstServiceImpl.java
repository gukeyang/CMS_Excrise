package com.ujcmsitems.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ujcmsitems.core.domain.First;
import com.ujcmsitems.core.mapper.FirstMapper;
import com.ujcmsitems.core.service.FirstService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ujcmsitems.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xingchen
 * @since 2022-10-15
 */
@Service
public class FirstServiceImpl extends ServiceImpl<FirstMapper, First> implements FirstService {

    @Autowired
    private FirstMapper firstMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean modify(First first) {
        QueryWrapper<First> courseQueryWrapper=new QueryWrapper<>();
        String firstTargetName = first.getFirstTargetName();
        courseQueryWrapper.eq("firstTargetName",firstTargetName);
        First first1 = firstMapper.selectOne(courseQueryWrapper);
        if(first1==null){
            firstMapper.updateById(first);
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer professionalId) {
        return firstMapper.deleteById(professionalId)>0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteMore(Integer[] professionalId) {
        return firstMapper.deleteBatchIds(Arrays.asList(professionalId))>0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public IPage<First> getPageFirst(Integer currentPage, Integer pageSize) {
        IPage page=new Page(currentPage,pageSize);
        firstMapper.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<First> searchFirst(Integer currentPage, Integer pageSize, String search) {
        QueryWrapper<First> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("firstTargetName",search);
        IPage<First> page=new Page<>(currentPage,pageSize);
        firstMapper.selectPage(page, queryWrapper);
        return page;
    }

    @Override
    public R saveFirst(String firstTargetName) {
        First first = new First(firstTargetName);
        QueryWrapper<First> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.eq("firstTargetName", firstTargetName);
        First first1 = firstMapper.selectOne(courseQueryWrapper);
        if (first1==null) {
            firstMapper.insert(first);
            return new R(true, 1,"添加成功^_^");
        } else {
            return new R(false, 0,"添加失败,该第一目录已存在-_-!");
        }
    }
}
