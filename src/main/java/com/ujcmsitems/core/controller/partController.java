package com.ujcmsitems.core.controller;




import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ujcmsitems.core.domain.partM;
import com.ujcmsitems.core.service.partMService;
import com.ujcmsitems.core.service.partSService;
import com.ujcmsitems.utils.R;
import com.ujcmsitems.utils.MinIoUtil;
import com.ujcmsitems.utils.Response;
import io.minio.errors.*;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Api(tags = "区块管理和设置")
@Controller
@CrossOrigin
@RequestMapping("/toPart")
public class partController {


    @Resource
    private partMService partMservice;
    @Resource
    private partSService partSService;

    /**
     * 区块的管理
     */

//    //新增区块
//    @ApiOperation(value = "新增模块")
//    @PostMapping("/addPartMTest")
//    @ResponseBody
//    public Response addPart(String title, Long part, MultipartFile picture) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
//        String bucketName = "test";
//        System.out.println("8888888888888888"+bucketName);
//        if (StringUtils.isBlank(bucketName)) {
//            return Response.error("存储bucket名称为空，无法上传");
//        }
//        System.out.println("66766666666666666666");
//        MinIoUtil minIoUtil=new MinIoUtil();
//        String path=minIoUtil.upload(picture);
//        partMservice.addPartM(title, path, part);
//        return Response.ok("success!");
//    }



    @PostMapping("/savePartM")
    @ResponseBody
    //增添
    public Response savePartM(String title, String picture, Long part) {
   //     System.out.println("6666666666666666666666");
        return partMservice.addPartM(title, picture, part);
    }

    @GetMapping("/deletePartM")
    @ResponseBody
    //删除
    public String deletePartM(Long id){
        return partMservice.deletePartM(id);
    }

    @PutMapping("/updatePartM")
    @ResponseBody
    //修改
    public R updatePartM(Long id, String title, String picture, Long part){
        return new R(true,partMservice.updatePartM(id,title,picture,part));
    }

    @GetMapping("/searchPartM")
    @ResponseBody
    //查询
    public R  searchPartM(Long id){
        return new R(true,partMservice.findPartMById(id));
    }

    /**
     * 区块的设置
     */

    @PostMapping("/savePartS")
    @ResponseBody
    //增添
    public R savePartS(String name, String status) {
        return new R(true,partSService.addPartS(name, status));
    }

    @GetMapping("/deletePartS")
    @ResponseBody
    //删除
    public R deletePartS(Long id){
        return new R(true,partSService.deletePartS(id));
    }

    @PutMapping("/updatePartS")
    @ResponseBody
    //修改
    public R updatePartS(Long id, String name, String status){
        return new R(true,partSService.updatePartS(id,name,status));
    }

    @GetMapping("/searchPartS")
    @ResponseBody
    //查询
    public R  searchPartS(Long id){
        return new R(true,partSService.findPartSById(id));
    }

}
