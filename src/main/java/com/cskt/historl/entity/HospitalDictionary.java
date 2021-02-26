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
    * 医院字典表
    */
@ApiModel(value="com-referral-referralbackstage-entity-HospitalDictionary")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "hospital_dictionary")
public class HospitalDictionary implements Serializable {
    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="编号")
    private Integer id;

    /**
     * 医院id（字典组编号）
     */
    @TableField(value = "hospital_id")
    @ApiModelProperty(value="医院id（字典组编号）")
    private Integer hospitalId;

    /**
     * 字典组名称
     */
    @TableField(value = "name")
    @ApiModelProperty(value="字典组名称")
    private String name;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}