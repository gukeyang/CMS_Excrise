package com.ujcmsitems.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ujcmsitems.core.domain.ObjectItem;
import com.ujcmsitems.core.mapper.ObjectItemMapper;
import com.ujcmsitems.core.service.ObjectItemService;
import com.ujcmsitems.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a1002
 */
@Service
public class ObjectItemServiceImpl extends ServiceImpl<ObjectItemMapper, ObjectItem> implements ObjectItemService {

    @Autowired
    private ObjectItemService objectItemService;
    @Autowired
    private ObjectItemMapper mapper;

    @Override
    public void removeByPath(List<String> objectName) {
        LambdaQueryWrapper<ObjectItem> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(ObjectItem::getObjectName, objectName);
        objectItemService.remove(queryWrapper);

    }

    @Override
    public void removeByHtitle(String htitle) {
        LambdaQueryWrapper<ObjectItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ObjectItem::getHtitle, htitle);
        objectItemService.remove(wrapper);
    }

    @Override
    public IPage<ObjectItem> getPageObject(Integer currentPage, Integer pageSize) {
        Page page = new Page(currentPage,pageSize);
        mapper.selectPage(page,null);
        return page;
    }

    //实现分页模糊查询
    @Override
    public IPage<ObjectItem> getPageObjectLike(Integer currentPage, Integer pageSize, String search) {
        QueryWrapper<ObjectItem> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.like("htitle",search);
        Page<ObjectItem> objectPage = new Page<>(currentPage, pageSize);
        mapper.selectPage(objectPage, objectQueryWrapper);
        return objectPage;
    }

    /**
     * 实现模糊查询
     * @param htitle
     * @return
     */
    @Override
    public List<ObjectItem> searchByLike(String htitle) {
        QueryWrapper<ObjectItem> wrapper = new QueryWrapper<>();
        wrapper.like("htitle", htitle);
        List<ObjectItem> objectItems = mapper.selectList(wrapper);
        return objectItems;
    }

    /**
     * 通过id查询
     */
    public ObjectItem getObjectItemsById(Long id){
        LambdaQueryWrapper<ObjectItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ObjectItem::getId, id);
        return objectItemService.getOne(wrapper);
    }


}
