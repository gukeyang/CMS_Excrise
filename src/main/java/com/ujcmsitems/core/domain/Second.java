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
@ApiModel(value="Second对象", description="")
public class Second implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "第二目录id")
    @TableId(value = "secondId", type = IdType.AUTO)
    private Integer secondId;

    @ApiModelProperty(value = "第一目录id")
    private Integer firstId;

    @ApiModelProperty(value = "第二目录名字")
    private String secondTargetName;

    @ApiModelProperty(value = "页面地址")
    private String url;

    public Second(Integer firstId, String secondTargetName) {
        this.firstId = firstId;
        this.secondTargetName = secondTargetName;
        this.url = url;
    }
}
