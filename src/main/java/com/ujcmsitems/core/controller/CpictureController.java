package com.ujcmsitems.core.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ujcmsitems.core.domain.Picture;
import com.ujcmsitems.core.service.impl.CpictureServiceImpl;
import com.ujcmsitems.utils.MinIoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@Api(tags = "轮播图")
@RestController
public class CpictureController {
    @Autowired
    private  CpictureServiceImpl cpictureService;
    @Autowired
    private MinIoUtil minIoUtil;
    @ApiOperation(value = "上传图片")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "", value = "", required = true),
//    })
    @PostMapping("/pictureupload")
    public String upload(MultipartFile file,String pictureName) {
        String bucketName = "carousel";
        System.out.println(bucketName);
        if (StringUtils.isBlank(bucketName)) {
            return "存储bucket名称为空，无法上传";
        }
        if (!minIoUtil.uploadCPicture(file,pictureName)) {
            return "图片上传失败";
        }
        return "图片上传成功";
    }


    @PostMapping("/getallurl")
    @ApiOperation("获取所有照片url")
    public List<String> Getallurl(){
        return cpictureService.Getallurl();
    }

    @GetMapping("/getpictureinformation")
    @ApiOperation("获取所有照片信息")
    public List<Picture> Getpictureinformation(){
        return cpictureService.GetPictureinformation();
    }

    @DeleteMapping("/deletebyid")
    @ApiOperation("根据id删除图片")
    public String deletebyid(long id){
        if (cpictureService.Delete(id)){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

}
