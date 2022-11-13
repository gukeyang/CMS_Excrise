package com.ujcmsitems.core.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ujcmsitems.core.domain.Picture;
import com.ujcmsitems.core.mapper.PictureMapper;
import com.ujcmsitems.core.service.PictureService;
import com.ujcmsitems.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author a1002
 */
@SuppressWarnings("all")
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture> implements PictureService {

    @Resource
    private PictureService pictureService;


    @Override
    @Transactional
    public Response upload(MultipartFile file, String imgName) throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();
        String img = encoder.encode(file.getBytes());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh-ss");
        Date date = new Date();
        Picture picture = new Picture(img, format.format(date), imgName);
        pictureService.save(picture);
        return Response.ok("success");
    }

    @Override
    @Transactional
    public void listUpload(HttpServletRequest request, HttpServletResponse response, Long id) throws IOException {
        Picture picture = pictureService.getById(id);
        byte[] byteAry = (byte[]) picture.getImgPath();
        String data = new String(byteAry, "UTF-8");
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(data);
        for (int i = 0; i < bytes.length; ++i) {
            if (bytes[i] < 0) {
                bytes[i] += 256;
            }
        }

//        byte[] byteTime = picture.getImgTime().getBytes();
//        byte[] byteName = picture.getImgName().getBytes();

        response.setContentType("image/jpeg");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);
//        outputStream.write(byteTime);
//        outputStream.write(byteName);
        outputStream.flush();
        outputStream.close();

    }

    @Override
    @Transactional
    public Response deleteImg(Long id) {
        pictureService.removeById(id);
        return Response.ok("success");
    }

    @Override
    @Transactional
    public Response updateImg(Long id, MultipartFile file, String imgName) throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();
        String img = encoder.encode(file.getBytes());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh-ss");
        Date date = new Date();
        pictureService.removeById(id);
        Picture picture = new Picture(id, img, format.format(date), imgName);
        pictureService.save(picture);
        return Response.ok("success");
    }
}