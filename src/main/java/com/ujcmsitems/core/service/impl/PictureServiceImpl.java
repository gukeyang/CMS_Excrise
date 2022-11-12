package com.ujcmsitems.core.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ujcmsitems.core.domain.Picture;
import com.ujcmsitems.core.mapper.PictureMapper;
import com.ujcmsitems.core.service.PictureService;
import com.ujcmsitems.utils.R;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author a1002
 */ //public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture> implements PictureService {
//}
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture> implements PictureService {

    @Resource
    private PictureService pictureService;


    @Override
    public R upload(MultipartFile file, String imgName) throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();
        String img = encoder.encode(file.getBytes());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh-ss");
        Date date = new Date();
        Picture picture = new Picture(img, format.format(date), imgName);
        pictureService.save(picture);
        return null;
    }
}