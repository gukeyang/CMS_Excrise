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
    public void removeByPath(List<String> path) {
        LambdaQueryWrapper<ObjectItem> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(ObjectItem::getObjectName, path);
        objectItemService.remove(queryWrapper);

    }

    @Override
    public IPage<ObjectItem> getPageObject(Integer currentPage, Integer pageSize) {
        Page page = new Page(currentPage,pageSize);
        mapper.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<ObjectItem> getPageObjectLike(Integer currentPage, Integer pageSize, String search) {
        QueryWrapper<ObjectItem> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.like("objectName",search);
        Page<ObjectItem> objectPage = new Page<>(currentPage, pageSize);
        mapper.selectPage(objectPage, objectQueryWrapper);
        return objectPage;
    }

}
