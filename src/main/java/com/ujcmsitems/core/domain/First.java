package com.ujcmsitems.core.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author xingchen
 * @since 2022-10-15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="First对象", description="")
public class First implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "第一目录的id")
    @TableId(value = "first_Id", type = IdType.AUTO)
    private Integer firstId;

    @ApiModelProperty(value = "第一目录名字")
    private String firstTargetName;


    public First(String firstTargetName) {
        this.firstTargetName = firstTargetName;
    }
}
