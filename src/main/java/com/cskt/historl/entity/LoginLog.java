package com.cskt.historl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
    * 登录日志
    */
@ApiModel(value="com-referral-referralbackstage-entity-LoginLog")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "login_log")
public class LoginLog implements Serializable {
    /**
     * 登录id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="登录id")
    private Integer id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value="用户id")
    private Integer userId;

    /**
     * 登录用户名
     */
    @TableField(value = "user_name")
    @ApiModelProperty(value="登录用户名")
    private String userName;

    /**
     * 登录结果
     */
    @TableField(value = "login_result")
    @ApiModelProperty(value="登录结果")
    private Integer loginResult;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}