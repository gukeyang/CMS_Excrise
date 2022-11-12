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
public class Picture {
    private Long id;
    private Object imgPath;
    private String imgTime;
    private String imgName;

    public Picture(Object imgPath, String imgTime, String imgName) {
        this.imgPath = imgPath;
        this.imgTime = imgTime;
        this.imgName = imgName;
    }
}
