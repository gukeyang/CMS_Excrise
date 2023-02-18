package com.ujcmsitems.core.domain;

import com.baomidou.mybatisplus.annotation.TableField;
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
    private Long id;
    @TableField("object_name")
    private String objectName;
    private Long size;

    @TableField("htitle")
    private String htitle;
    @TableField("hpart")
    private String hpart;

}
