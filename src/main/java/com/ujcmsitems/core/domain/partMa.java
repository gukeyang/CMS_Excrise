package com.ujcmsitems.core.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="区块实体类", description="")
public class partMa {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "区块的id")
    private Integer id;
    @ApiModelProperty(value = "区块的标题")
    private String title;
    @ApiModelProperty(value = "区块的别名")
    private String alias;
    @ApiModelProperty(value = "区块的状态")
    private Integer state;

    public partMa(Integer id, String title,  Integer state) {
        this.id = id;
        this.title = title;
        this.alias = alias;
        this.state = state;
    }

}
