package com.ujcmsitems.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ujcmsitems.core.domain.Picture;
import com.ujcmsitems.utils.R;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author a1002
 */
public interface PictureService extends IService<Picture> {
    R upload(MultipartFile file, String imgName) throws IOException;
}
