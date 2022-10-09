package com.ujcmsitems.core.service;

import com.ujcmsitems.core.domain.JwtUser;
import com.ujcmsitems.core.domain.Manager;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ujcmsitems.utils.R;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xingchen
 * @since 2022-10-09
 */
public interface ManagerService extends IService<Manager> {

  
    JwtUser isLogin(HttpServletRequest request);

    R login(String admin, String password);

    R register(String admin, String password);

    //退出登录
    void quit(HttpServletRequest request);
}
