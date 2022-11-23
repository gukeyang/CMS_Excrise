package com.ujcmsitems.core.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ujcmsitems.core.config.MinIoClientConfig;
import com.ujcmsitems.core.domain.ObjectItem;
import com.ujcmsitems.core.service.ObjectItemService;
import com.ujcmsitems.utils.MinIoUtil;
import io.minio.Result;
import io.minio.messages.DeleteError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author a1002
 */
@Api(tags = "文件处理")
@RestController
//@RequestMapping("/minio")
public class MinioController {

    @Autowired
    private ObjectItemService objectItemService;

    @Autowired
    private MinIoClientConfig minIoClientConfig;
    @Autowired
    private MinIoUtil minIoUtil;

    @ApiOperation(value = "上传文件")
    @ResponseBody
    @PostMapping("/minioUpload")
    public String upload(MultipartFile file) {
        String bucketName = "test";
        System.out.println(bucketName);
        if (StringUtils.isBlank(bucketName)) {
            return "存储bucket名称为空，无法上传";
        }
        if (!minIoUtil.upload(file)) {
            return "文件上传异常";
        }
        return "文件上传成功";
    }

    @ApiOperation(value = "下载文件")
    @ResponseBody
    @GetMapping("/minioDownload")
    public String download(String path, HttpServletResponse res) {
        minIoUtil.download("test", path, res);
        return "success";
    }

    @ApiOperation(value = "查看桶内所有文件")
    @ResponseBody
    @GetMapping("/listBucket")
    public List<ObjectItem> listObjects(String bucketName) {
        return minIoUtil.listObjects(bucketName);
    }

    @ApiOperation(value = "查看桶内某个文件")
    @ResponseBody
    @GetMapping("/listFile")
    public void listObjectsFile(String fileName, HttpServletResponse res) throws Exception {
        minIoUtil.getObjectsByFileName(fileName, res);
    }

    @ApiOperation(value = "批量删除桶内文件")
    @ResponseBody
    @DeleteMapping("/deleteBatchBucket")
    public Iterable<Result<DeleteError>> removeObjects(@RequestParam("objects") List<String> objects) {
        objectItemService.removeByPath(objects);
        return minIoUtil.removeObjects(objects);
    }
}
