package com.ujcmsitems.utils;

import com.ujcmsitems.core.domain.ObjectItem;
import com.ujcmsitems.core.domain.Picture;
import com.ujcmsitems.core.mapper.PictureMapper;
import com.ujcmsitems.core.service.CpictureService;
import com.ujcmsitems.core.service.ObjectItemService;
import com.ujcmsitems.core.service.PictureService;
import io.minio.*;
import io.minio.errors.*;
import io.minio.messages.DeleteError;
import io.minio.messages.DeleteObject;
import io.minio.messages.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class MinIoUtil {

    @Value("${minio.bucketName}")
    private String bucketName;

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private ObjectItemService objectItemService;
//    @Resource
//    private ObjectItemService objectItemService;

    /**
     * 查看存储bucket是否存在
     *
     * @param bucketName 存储bucket
     * @return boolean
     */
    public Boolean bucketExists(String bucketName) {
        Boolean found;
        try {
            found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return found;
    }

    /**
     * 创建存储bucket
     *
     * @param bucketName 存储bucket名称
     * @return Boolean
     */

    public Boolean makeBucket(String bucketName) {
        try {
            minioClient.makeBucket(MakeBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 删除存储bucket
     *
     * @param bucketName 存储bucket名称
     * @return Boolean
     */
    public Boolean removeBucket(String bucketName) {
        try {
            minioClient.removeBucket(RemoveBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 文件上传
     *
     * @param file 文件
     * @param
     * @return Boolean
     */
    public Boolean upload(MultipartFile file,String title,String part) {
        try {
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String fileNewName = System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String filePathc = sdf.format(d) + "&&" + fileNewName;
            String name="test";
            PutObjectArgs objectArgs = PutObjectArgs.builder().bucket(name).object(filePathc)
                    .stream(file.getInputStream(), file.getSize(), -1).contentType(file.getContentType()).build();
            //文件名称相同会覆盖
            minioClient.putObject(objectArgs);

            /*********************/
            log.info("filepath=========={}", filePathc);
            log.info("fileName=========={}", fileNewName);

            Iterable<Result<Item>> results = minioClient.listObjects(
                    ListObjectsArgs.builder().bucket(bucketName).build());

            ObjectItem objectItem = new ObjectItem();
            objectItem.setObjectName(filePathc);
            objectItem.setHtitle(title);
            objectItem.setHpart(part);

            try {
                for (Result<Item> result : results) {
                    Item item = result.get();
                    if (item.objectName().equals(filePathc)) {
                        objectItem.setSize(item.size());
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            objectItemService.save(objectItem);

            /*********************/
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }





    @Value("${minio.endpoint}")
    private String minioip;
    private String PbucketName = "carousel";
    @Autowired
    private PictureMapper pictureMapper;

    /**
     * 图片上传
     *
     * @param file 图片
     * @return Boolean
     */
    public Boolean uploadCPicture(MultipartFile file,String CPictureName) {

        try {
            bucketName = "carousel";
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String filePathc = sdf.format(d) + "&&" + CPictureName;
            PutObjectArgs objectArgs = PutObjectArgs.builder().bucket(bucketName).object(filePathc)
                    .stream(file.getInputStream(), file.getSize(), -1).contentType(file.getContentType()).build();
            //文件名称相同会覆盖
            minioClient.putObject(objectArgs);
            /*********************/

            log.info("filepath=========={}", filePathc);
            log.info("fileName=========={}", CPictureName);
            Picture picture = new Picture( null,minioip + "/" + PbucketName + "/" + filePathc,sdf.format(d),CPictureName);
            System.out.println(picture.getId());
            pictureMapper.insert(picture);

            //将照片信息存储到数据库中

            /*********************/
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * 文件下载
     *
     * @param bucketName 存储bucket名称
     * @param fileName   文件名称
     * @param res        response
     * @return Boolean
     */
    public void download(String bucketName, String fileName, HttpServletResponse res) {
        GetObjectArgs objectArgs = GetObjectArgs.builder().bucket(bucketName)
                .object(fileName).build();
        try (GetObjectResponse response = minioClient.getObject(objectArgs)) {
            byte[] buf = new byte[1024];
            int len;
            try (FastByteArrayOutputStream os = new FastByteArrayOutputStream()) {
                while ((len = response.read(buf)) != -1) {
                    os.write(buf, 0, len);
                }
                os.flush();
                byte[] bytes = os.toByteArray();
                res.setCharacterEncoding("utf-8");
                //设置强制下载不打开
                res.setContentType("application/force-download");
                res.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
                try (ServletOutputStream stream = res.getOutputStream()) {
                    stream.write(bytes);
                    stream.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据文件名查询文件
     *
     * @param fileName 文件名
     * @return MinioItem 列表
     * @throws Exception
     */
    public void getObjectsByFileName(String fileName, HttpServletResponse res) throws Exception {
        GetObjectArgs objectArgs = GetObjectArgs.builder().bucket(bucketName)
                .object(fileName).build();
        try (GetObjectResponse response = minioClient.getObject(objectArgs)) {
            byte[] buf = new byte[1024];
            int len;
            try (FastByteArrayOutputStream os = new FastByteArrayOutputStream()) {
                while ((len = response.read(buf)) != -1) {
                    os.write(buf, 0, len);
                }
                os.flush();
                byte[] bytes = os.toByteArray();
                res.setCharacterEncoding("utf-8");
                //设置强制下载不打开
                //       res.setContentType("application/force-download");
                //    res.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
                res.setContentType("image/jpeg");
                try (ServletOutputStream stream = res.getOutputStream()) {
                    stream.write(bytes);
                    stream.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 查看文件对象
     *
     * @param bucketName 存储bucket名称
     * @return 存储bucket内文件对象信息
     */
    public List<ObjectItem> listObjects(String bucketName) {
        Iterable<Result<Item>> results = minioClient.listObjects(
                ListObjectsArgs.builder().bucket(bucketName).build());
        List<ObjectItem> objectItems = new ArrayList<>();
        try {
            for (Result<Item> result : results) {
                Item item = result.get();
                ObjectItem objectItem = new ObjectItem();
                objectItem.setObjectName(item.objectName());
                /*********************/
                log.info("item.objectName=========={}", item.objectName());
                log.info("item.size=========={}", item.size());

                /*********************/
                objectItem.setSize(item.size());
                objectItems.add(objectItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return objectItems;
    }

    /**
     * 批量删除文件对象
     * <p>
     * bucketName 存储bucket名称
     *
     * @param objects 对象名称集合
     */
    public Iterable<Result<DeleteError>> removeObjects(List<String> objects) {
        List<DeleteObject> dos = objects.stream().map(e -> new DeleteObject(e)).collect(Collectors.toList());
        Iterable<Result<DeleteError>> results = minioClient.removeObjects(RemoveObjectsArgs.builder().bucket(bucketName).objects(dos).build());
        return results;
    }


}
