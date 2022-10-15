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
@ApiModel(value="Characteristic对象", description="")
public class Characteristic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "文章标题")
    private String chTitle;

    @ApiModelProperty(value = "文章内容")
    private String chContent;

    @ApiModelProperty(value = "所属一级目录")
    private String firstTarget;

    @ApiModelProperty(value = "所属二级目录")
    private String secondTarget;

    @ApiModelProperty(value = "文章审核状态")
    private Integer state;


    public Characteristic(String chTitle, String chContent, String firstTarget, String secondTarget) {
        this.chTitle = chTitle;
        this.chContent = chContent;
        this.firstTarget = firstTarget;
        this.secondTarget = secondTarget;
    }

    public Characteristic(Integer id, String chTitle, String chContent, String firstTarget, String secondTarget) {
        this.id = id;
        this.chTitle = chTitle;
        this.chContent = chContent;
        this.firstTarget = firstTarget;
        this.secondTarget = secondTarget;
    }
}
