package com.ujcmsitems.core.controller;





import com.ujcmsitems.core.service.partMService;
import com.ujcmsitems.utils.R;
import com.ujcmsitems.utils.Response;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "区块管理")
@Controller
@CrossOrigin
@RequestMapping("/partm")
public class PartMController {


    @Resource
    private partMService partMservice;

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


}
