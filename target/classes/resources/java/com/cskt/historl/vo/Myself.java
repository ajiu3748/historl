package com.cskt.historl.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 我
 * @author: Mr.阿九
 * @createTime: 2021-02-20 18:18
 **/
@Data
public class Myself {
    /**
     * 头像
     */
    @TableField(value = "user_img")
    @ApiModelProperty(value="头像")
    private String userImg;
    /**
     * 用户名称
     */
    @TableField(value = "user_name")
    @ApiModelProperty(value="用户名称")
    private String userName;

    /**
     * 用户手机号
     */
    @TableField(value = "user_phone")
    @ApiModelProperty(value="用户手机号")
    private String userPhone;
    /**
     * 职称名称
     */
    @TableField(value = "positional_name")
    @ApiModelProperty(value="职称名称")
    private String positionalName;
    /**
     * 科室名称
     */
    @TableField(value = "department_name")
    @ApiModelProperty(value="科室名称")
    private String departmentName;
    /**
     * 医院名称
     */
    @TableField(value = "name")
    @ApiModelProperty(value="医院名称")
    private String name;
}
