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
    * 患者详情
    */
@ApiModel(value="com-referral-referralbackstage-entity-SuffererDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sufferer_details")
public class SuffererDetails implements Serializable {
    /**
     * 患者详情id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="患者详情id")
    private Integer id;

    /**
     * 患者名字
     */
    @TableField(value = "sufferer_name")
    @ApiModelProperty(value="患者名字")
    private String suffererName;

    /**
     * 患者手机号
     */
    @TableField(value = "sufferer_phone")
    @ApiModelProperty(value="患者手机号")
    private String suffererPhone;

    /**
     * 患者年龄
     */
    @TableField(value = "sufferer_age")
    @ApiModelProperty(value="患者年龄")
    private Integer suffererAge;

    /**
     * 患者性别
     */
    @TableField(value = "sufferer_sex")
    @ApiModelProperty(value="患者性别")
    private Integer suffererSex;

    /**
     * 患者身高
     */
    @TableField(value = "sufferer_height")
    @ApiModelProperty(value="患者身高")
    private Integer suffererHeight;

    /**
     * 患者体重
     */
    @TableField(value = "sufferer_weight")
    @ApiModelProperty(value="患者体重")
    private Integer suffererWeight;

    /**
     * 修改时间
     */
    @TableField(value = "upddate_time")
    @ApiModelProperty(value="修改时间")
    private Date upddateTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value="排序")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}