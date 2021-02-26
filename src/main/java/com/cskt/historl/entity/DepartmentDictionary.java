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
    * 科室字典
    */
@ApiModel(value="com-referral-referralbackstage-entity-DepartmentDictionary")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "department_dictionary")
public class DepartmentDictionary implements Serializable {
    /**
     * 科室id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="科室id")
    private Integer id;

    /**
     * 科室名称
     */
    @TableField(value = "department_name")
    @ApiModelProperty(value="科室名称")
    private String departmentName;

    /**
     * 会诊
     */
    @TableField(value = "group_consultation")
    @ApiModelProperty(value="会诊")
    private Integer groupConsultation;

    /**
     * 转诊
     */
    @TableField(value = "referral")
    @ApiModelProperty(value="转诊")
    private Integer referral;

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