package com.ujcmsitems.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ujcmsitems.core.domain.Second;
import com.ujcmsitems.core.mapper.SecondMapper;
import com.ujcmsitems.core.service.SecondService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xingchen
 * @since 2022-10-15
 */
@Service
public class SecondServiceImpl extends ServiceImpl<SecondMapper, Second> implements SecondService {


    @Autowired
    private SecondMapper secondMapper;
    @Override
    public boolean delete(Integer secondId) {
        return secondMapper.deleteById(secondId)>0;
    }

    @Override
    public boolean deleteMore(Integer[] secondId) {
        return secondMapper.deleteBatchIds(Arrays.asList(secondId))>0;

    }

    /**
     * @param second
     * @return
     */
    @Override
    public boolean updateSecond(Second second) {
        QueryWrapper<Second> secondQueryWrapper=new QueryWrapper<>();
        String secondTargetName= second.getSecondTargetName();
        Integer firstId = second.getFirstId();
        secondQueryWrapper.eq("first_id",firstId);
        List<Second> secondList = secondMapper.selectList(secondQueryWrapper);
        for(Second course1:secondList){
            String secondTargetName1 = course1.getSecondTargetName();
            if(!secondTargetName1.equals(secondTargetName)){
                secondMapper.updateById(second);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Second> getAllSecond(Integer firstId) {
        QueryWrapper<Second> courseQueryWrapper=new QueryWrapper<>();
        courseQueryWrapper.eq("first_id",firstId);
        List<Second> seconds = secondMapper.selectList(courseQueryWrapper);
        return seconds;
    }

    @Override
    public IPage<Second> getPageSecond(Integer firstId, Integer currentPage, Integer pageSize) {
        QueryWrapper<Second> courseQueryWrapper=new QueryWrapper<>();
        courseQueryWrapper.eq("first_id",firstId);
        IPage page=new Page(currentPage,pageSize);
        secondMapper.selectPage(page,courseQueryWrapper);
        return page;
    }

    @Override
    public Set<String> getPageAllSecond() {
        QueryWrapper<Second> courseQueryWrapper=new QueryWrapper<>();
        List<Second> seconds = secondMapper.selectList(courseQueryWrapper);
        Set<String> stringSet=new HashSet<>();
        for(Second second:seconds){
            String secondTargetName = second.getSecondTargetName();
            stringSet.add(secondTargetName);
        }
        return stringSet;
    }

    @Override
    public IPage<Second> searchPageSecond(Integer firstId, String search, Integer currentPage, Integer pageSize) {
        QueryWrapper<Second> courseQueryWrapper=new QueryWrapper<>();
        courseQueryWrapper.eq("first_id",firstId);
        courseQueryWrapper.like("second_target_name",search);
        IPage page=new Page(currentPage,pageSize);
        secondMapper.selectPage(page,courseQueryWrapper);
        return page;
    }
}
