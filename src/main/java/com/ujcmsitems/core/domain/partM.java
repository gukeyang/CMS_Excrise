package com.ujcmsitems.core.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 *
 * @Author gukeyang
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="区块管理实体类", description="")
public class partM implements Serializable {

    @ApiModelProperty(value = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "图片")
    private String picture;
    @ApiModelProperty(value = "所属区块id")
    private Long part;

    public partM(String title, String picture, Long part) {
        this.title = title;
        this.picture = picture;
        this.part = part;
    }

}
