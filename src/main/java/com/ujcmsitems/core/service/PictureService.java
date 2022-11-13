package com.ujcmsitems.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ujcmsitems.core.domain.Picture;
import com.ujcmsitems.utils.Response;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author a1002
 */
public interface PictureService extends IService<Picture> {
    Response upload(MultipartFile file, String imgName) throws IOException;

    void listUpload(HttpServletRequest request, HttpServletResponse response, Long id) throws IOException;

    Response deleteImg(Long id);

    Response updateImg(Long id, MultipartFile file, String imgName) throws IOException;
}
