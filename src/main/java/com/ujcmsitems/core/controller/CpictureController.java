package com.ujcmsitems.core.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ujcmsitems.core.domain.Picture;
import com.ujcmsitems.core.service.impl.CpictureServiceImpl;
import com.ujcmsitems.utils.MinIoUtil;
import com.ujcmsitems.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@Api(tags = "轮播图")
@RestController
@RequestMapping("/picture")
public class CpictureController {
    @Autowired
    private  CpictureServiceImpl cpictureService;
    @Autowired
    private MinIoUtil minIoUtil;

    @ApiOperation(value = "上传图片")
    @PostMapping("/pictureUpload")
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


    @PostMapping("/getAllUrl")
    @ApiOperation("获取所有照片url")
    public List<String> Getallurl(){
        return cpictureService.Getallurl();
    }

    @GetMapping("/getPictureInformation")
    @ApiOperation("获取所有照片信息")
    public List<Picture> Getpictureinformation(){
        return cpictureService.GetPictureinformation();
    }

    @DeleteMapping("/deleteById")
    @ApiOperation("根据id删除图片")
    public String deletebyid(long id){
        if (cpictureService.Delete(id)){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    @PostMapping("/replace")
    @ApiOperation("修改图片名称")
    public String deletebyid(long id,String imgName){
        if (cpictureService.replace(id,imgName)){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    @GetMapping("/getPageAllPicture")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页数", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页个数", required = true)
    })
    public R getPageAllPicture(Integer currentPage, Integer pageSize) {
        IPage<Picture> page = cpictureService.getPagePicture(currentPage, pageSize);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = cpictureService.getPagePicture((int) page.getPages(), pageSize);
        }
        return new R(true,page);
    }



}
