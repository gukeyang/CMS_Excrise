package com.ujcmsitems.core.controller;


import com.ujcmsitems.core.service.PictureService;
import com.ujcmsitems.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author a1002
 */
@Api(tags = "picture")
@RestController
@RequestMapping("/picture")
public class PictureController {
    @Resource
    private PictureService pictureService;

    @ApiOperation(value = "上传图片")
    @PostMapping(value = "/addImg")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "选择图片", required = true),
            @ApiImplicitParam(name = "imgName", value = "备注", required = true)
    })
    @ResponseBody
    public R upload(@RequestParam("files") MultipartFile files, String imgName) throws IOException {
        return pictureService.upload(files, imgName);
    }
}
