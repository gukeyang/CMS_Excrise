package com.ujcmsitems.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ujcmsitems.core.domain.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CpictureService extends IService<Picture> {

    /**
     * 上传图片
     * @param file
     * @param imgName
     * @return
     */
    boolean upload(MultipartFile file, String imgName , Long type);

    /**
     * 获取图片信息
     * @return
     */

    List<Picture> GetPictureinformation();

    /**
     * 删除图片
     * @param id
     * @return
     */

    boolean Delete(Long id);

    /**
     * 获取图片url地址
     * @return
     */

    List<String> Getallurl();

    /**
     * 修改图片信息
     * @param id
     * @param imgName
     * @return
     */

    boolean replace (Long id,String imgName,String imgPath,Long type);

    /**
     * 批量删除
     * @param id
     * @return
     */

    boolean deleteMoreImg(Integer[] id);

    /**getPagePicture方法是用于获取一页Picture对象，而
     *分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<Picture> getPagePicture(Integer currentPage, Integer pageSize);

    /**searchPicture方法是用于按照条件搜索并分页显示符合条件的Picture对象。
     *关键字分页查询
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    IPage<Picture> searchPicture(Integer currentPage, Integer pageSize, String search);

}
