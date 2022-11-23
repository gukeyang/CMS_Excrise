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
    private Long id;
    private String objectName;
    private Long size;

    public ObjectItem(String objectName, Long size) {
        this.objectName = objectName;
        this.size = size;
    }
}
