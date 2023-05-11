package com.ujcmsitems.core.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ujcmsitems.core.domain.Picture;
import com.ujcmsitems.core.mapper.PictureMapper;
import com.ujcmsitems.core.service.CpictureService;
import com.ujcmsitems.utils.MinIoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CpictureServiceImpl extends ServiceImpl<PictureMapper,Picture> implements CpictureService {



    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private MinIoUtil minIoUtil;

    @Override
    public boolean upload(MultipartFile file, String imgName,Integer type) {
        return minIoUtil.uploadCPicture(file,imgName,type);
    }

    @Override
    public List<Picture> GetPictureinformation() {
        return pictureMapper.selectList(null);
    }

    @Override
    public boolean Delete(Long id) {
        if (pictureMapper.deleteById(id) == 0) {
            return false;
        } else {
            return true;
        }
    }


    @Override
    public List<String> Getallurl() {
        ArrayList<String> a = new ArrayList<>();
        for (Picture picture : pictureMapper.selectList(null)) {
            a.add(picture.getImgPath());
        }
        return a;
    }

    @Override
    public boolean replace(Long id, String imgName,String imgPath,Integer type) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Picture picture = new Picture(id,imgPath,sdf.format(d),imgName,type);
      boolean a = true;
      try {
          a =  pictureMapper.updateById(picture) != 0;
      }catch (Exception e){
          System.out.println(e);
      }
      return a;
    }

    @Override
    public boolean deleteMoreImg(Integer[] id) {
        return pictureMapper.deleteBatchIds(Arrays.asList(id))>0;
    }

    @Override
    public IPage<Picture> getPagePicture(Integer currentPage, Integer pageSize) {
        IPage page=new Page(currentPage,pageSize);
        pictureMapper.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Picture> searchPicture(Integer currentPage, Integer pageSize, String search) {
        QueryWrapper<Picture> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("imgName",search);
        IPage<Picture> page = new Page<>(currentPage,pageSize);
        pictureMapper.selectPage(page,queryWrapper);
        return page;
    }

}
