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
    * 转诊类型
    */
@ApiModel(value="com-referral-referralbackstage-entity-ReferralType")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "referral_type")
public class ReferralType implements Serializable {
    /**
     * 转诊类型id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="转诊类型id")
    private Integer id;

    /**
     * 转诊类型名字
     */
    @TableField(value = "name")
    @ApiModelProperty(value="转诊类型名字")
    private String name;

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

    private static final long serialVersionUID = 1L;
}