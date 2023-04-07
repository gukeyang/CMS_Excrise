package com.ujcmsitems.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guekyang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picture {

    //id
    private Long id;
    //图片地址
    private String imgPath;
    //创建时间
    private String imgTime;
    //图片名称
    private String imgName;

}
