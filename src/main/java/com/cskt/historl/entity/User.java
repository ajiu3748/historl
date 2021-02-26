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
    * 用户表
    */
@ApiModel(value="com-referral-referralbackstage-entity-User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`user`")
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    @ApiModelProperty(value="用户id")
    private Integer userId;

    /**
     * 登录名称
     */
    @TableField(value = "login_name")
    @ApiModelProperty(value="登录名称")
    private String loginName;

    /**
     * 登录密码
     */
    @TableField(value = "login_password")
    @ApiModelProperty(value="登录密码")
    private String loginPassword;

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
     * (字典)医院id
     */
    @TableField(value = "hospital_id")
    @ApiModelProperty(value="(字典)医院id")
    private Integer hospitalId;

    /**
     * (字典)科室id
     */
    @TableField(value = "department_id")
    @ApiModelProperty(value="(字典)科室id")
    private Integer departmentId;

    /**
     * (字典)职称id
     */
    @TableField(value = "positional_id")
    @ApiModelProperty(value="(字典)职称id")
    private Integer positionalId;

    /**
     * 头像
     */
    @TableField(value = "user_img")
    @ApiModelProperty(value="头像")
    private String userImg;

    /**
     * 身份
     */
    @TableField(value = "identity")
    @ApiModelProperty(value="身份")
    private Integer identity;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    /**
     * 逻辑删除
     */
    @TableField(value = "is_delete")
    @ApiModelProperty(value="逻辑删除")
    private Integer isDelete;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 微信的openid
     */
    @TableField(value = "wx_openid")
    @ApiModelProperty(value="微信的openid")
    private String wxOpenid;

    private static final long serialVersionUID = 1L;
}