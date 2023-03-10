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
    private String objectName;
    private Long size;

    private String htitle;

    private String hpart;

}
