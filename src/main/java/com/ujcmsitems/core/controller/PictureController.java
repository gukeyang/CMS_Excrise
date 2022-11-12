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
}
