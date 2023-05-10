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
    //
    private Long size;
    //
    private String htitle;
    //
    private String hpart;

}
