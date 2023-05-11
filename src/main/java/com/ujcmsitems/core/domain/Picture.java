package com.ujcmsitems.core.domain;

import lombok.*;

/**
 * @author guekyang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Picture {

    //id
    private Long id;
    //图片地址
    private String imgPath;
    //创建时间
    private String imgTime;
    //图片名称
    private String imgName;
    //图片类型
    private Integer type;
}
