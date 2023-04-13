package com.ujcmsitems.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ujcmsitems.core.domain.First;
import com.ujcmsitems.core.domain.Picture;
import com.ujcmsitems.utils.Response;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gukeyang
 */
public interface PictureService extends IService<Picture> {

    /**
     * 上传图片
     * @param file
     * @param imgName
     * @return
     * @throws IOException
     */
    Response upload(MultipartFile file, String imgName) throws IOException;

    /**
     * //查询所有图片
     * @param request
     * @param response
     * @param id
     * @throws IOException
     */
    void listUpload(HttpServletRequest request, HttpServletResponse response, Long id) throws IOException;

    /**
     * 通过id查询图片
     * @param id
     * @return
     */
    Response deleteImgById(Long id);

    /**
     * 修改图片信息
     * @param id
     * @param file
     * @param imgName
     * @return
     * @throws IOException
     */

    Response updateImg(Long id, MultipartFile file, String imgName) throws IOException;

    /**
     * 批量删除
     * @param id
     * @return
     */

    boolean deleteMoreImg(Integer[] id);

    /**
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<Picture> getPagePicture(Integer currentPage, Integer pageSize);

    /**
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    IPage<Picture> searchPicture(Integer currentPage, Integer pageSize, String search);
}
