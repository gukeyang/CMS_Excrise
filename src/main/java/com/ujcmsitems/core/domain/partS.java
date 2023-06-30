package com.ujcmsitems.core.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author gukeyang
 *
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="区块设置实体类", description="")
@EqualsAndHashCode(callSuper = false)
public class partS{

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "描述")
    private String status;

    public partS(String name, String status) {
        this.name = name;
        this.status = status;
    }
}
