package com.cskt.historl.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 用户的些名
 * @author: Mr.阿九
 * @createTime: 2021-02-22 10:54
 **/
@Data
public class UserName {
    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.INPUT)
    @ApiModelProperty(value="用户id")
    private Integer userId;
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
