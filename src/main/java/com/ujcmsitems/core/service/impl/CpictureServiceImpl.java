package com.ujcmsitems.core.service.impl;


import com.ujcmsitems.core.domain.Picture;
import com.ujcmsitems.core.mapper.PictureMapper;
import com.ujcmsitems.core.service.CpictureService;
import com.ujcmsitems.utils.MinIoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;

@Service
public class CpictureServiceImpl implements CpictureService {

    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private MinIoUtil minIoUtil;
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
