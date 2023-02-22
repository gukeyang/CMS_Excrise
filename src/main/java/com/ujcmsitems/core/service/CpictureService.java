package com.ujcmsitems.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ujcmsitems.core.domain.First;
import com.ujcmsitems.core.domain.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CpictureService  {

/**
 *
 *             1.上传图片
 *             2.获取图片信息
 *             3.删除图片
 *             4.获取图片url地址
 * */

    boolean upload(MultipartFile file, String imgName);

    List<Picture> GetPictureinformation();

    boolean Delete(Long id);

    List<String>  Getallurl();


}
