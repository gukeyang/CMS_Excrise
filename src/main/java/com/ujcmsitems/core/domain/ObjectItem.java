package com.ujcmsitems.core.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author a1002
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectItem {
    //id
    private Long id;
    //文件名称
    private String objectName;
    //大小
    private Long size;
    //标题
    private String htitle;
    //所属区块
    private String hpart;

}
