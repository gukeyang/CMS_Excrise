package com.ujcmsitems.core.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xingchen
 * @since 2022-10-09
 */
@Data
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
}

