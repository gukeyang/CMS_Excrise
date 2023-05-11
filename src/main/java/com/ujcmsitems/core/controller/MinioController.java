package com.ujcmsitems.core.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ujcmsitems.core.config.MinIoClientConfig;
import com.ujcmsitems.core.domain.First;
import com.ujcmsitems.core.domain.ObjectItem;
import com.ujcmsitems.core.service.ObjectItemService;
import com.ujcmsitems.utils.MinIoUtil;
import com.ujcmsitems.utils.R;
import io.minio.Result;
import io.minio.messages.DeleteError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author a1002
 */
@CrossOrigin
@Api(tags = "文件处理")
@Controller
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
    public String upload(MultipartFile file,String title,String part) {
        String bucketName = "test";
        System.out.println(bucketName);
        if (StringUtils.isBlank(bucketName)) {
            return "存储bucket名称为空，无法上传";
        }
        if (!minIoUtil.upload(file,title,part)) {
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
        String bucketName1 = bucketName = "test";
        return minIoUtil.listObjects(bucketName1);
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

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页查询数据")
    @GetMapping("/getPageObj")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页的数据量",required = true)

    })
    public R getPageObj(Integer currentPage, Integer pageSize){
        IPage<ObjectItem> Page = objectItemService.getPageObject(currentPage,pageSize);
        //如果当前页码数大于了总页码数，那么重新执行查询操作，使用最大页码值作为当前页码值
        if(currentPage > Page.getPages()){
            Page = objectItemService.getPageObject((int)Page.getPages() ,pageSize);
        }
        return new R(true, Page);
    }


    @ApiOperation(value = "分页模糊查询")
    @GetMapping(value = "/getPageObjLike")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页数", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页个数", required = true),
            @ApiImplicitParam(name = "search", value = "搜索词", required = true)
    })
    @ResponseBody
    public R getPageObjLike(Integer currentPage, Integer pageSize, String search) {
        IPage<ObjectItem> page = objectItemService.getPageObjectLike(currentPage, pageSize, search);
        if (currentPage > page.getPages()) {
            page = objectItemService.getPageObjectLike((int) page.getPages(),pageSize,search);
        }
        return new R(true, page);
    }






}


