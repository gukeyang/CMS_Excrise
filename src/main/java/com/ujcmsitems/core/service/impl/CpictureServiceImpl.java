package com.ujcmsitems.core.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ujcmsitems.core.domain.Picture;
import com.ujcmsitems.core.mapper.PictureMapper;
import com.ujcmsitems.core.service.CpictureService;
import com.ujcmsitems.utils.MinIoUtil;
import net.sf.jsqlparser.statement.select.Pivot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CpictureServiceImpl implements CpictureService {



    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private MinIoUtil minIoUtil;

    @Override
    public boolean replace(Long id, String imgName) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Picture picture = new Picture(id,null,sdf.format(d),imgName);
      boolean a = true;
      try {
          a =  pictureMapper.updateById(picture) != 0;
      }catch (Exception e){
          System.out.println(e);
      }
      return a;


    }

    @Override
    public boolean upload(MultipartFile file, String imgName) {
        return minIoUtil.uploadCPicture(file,imgName);
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

}
