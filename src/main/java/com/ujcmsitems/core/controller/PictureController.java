package com.ujcmsitems.core.controller;


import com.ujcmsitems.core.service.PictureService;
import com.ujcmsitems.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author a1002
 */
@Api(tags = "picture")
@RestController
//@RequestMapping("/picture")
public class PictureController {
    @Resource
    private PictureService pictureService;

    @ApiOperation(value = "上传图片")
    @PostMapping(value = "/addImg")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "imgName", value = "备注", required = true)
    })
    @ResponseBody
    public Response upload(@RequestParam("files") MultipartFile file, String imgName) throws IOException {
        return pictureService.upload(file, imgName);
    }

    @ApiOperation(value = "根据id查询图片")
    @PostMapping(value = "/FindImg")
    @ResponseBody
    public void listUpload(HttpServletRequest request, HttpServletResponse response, Long id) throws IOException {
        pictureService.listUpload(request, response, id);
    }

    @ApiOperation(value = "根据id delete图片")
    @PostMapping(value = "/DeleteImg")
    @ResponseBody
    public Response deleteImg(Long id) {
        return pictureService.deleteImg(id);
    }

    @ApiOperation(value = "根据id update图片")
    @PostMapping(value = "/UpdateImg")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "imgName", value = "备注", required = true),
    })
    public Response updateImg(Long id, @RequestParam("files") MultipartFile file, String imgName) throws IOException {
        return pictureService.updateImg(id, file, imgName);
    }
}
