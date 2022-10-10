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
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xingchen
 * @since 2022-10-09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Manager对象", description="")
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "管理员账号")
    private String admin;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "账号")
    private String username;


    @ApiModelProperty(value = "账号权限")
    /**
     * 0是用户
     * 1是管理员
     */
    private Integer userAuthority;


    @ApiModelProperty(value = "邮箱号")
    private String email;


    public Manager(String admin, String password) {
        this.admin = admin;
        this.password = password;
    }

    public Manager(String admin, String password, String username, String email) {
        this.admin = admin;
        this.password = password;
        this.username = username;
        this.email = email;
    }
}
