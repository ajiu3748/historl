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
    * 职称字典表
    */
@ApiModel(value="com-referral-referralbackstage-entity-PositionalDict")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "positional_dict")
public class PositionalDict implements Serializable {
    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="编号")
    private Integer id;

    /**
     * 字典编号
     */
    @TableField(value = "positional_id")
    @ApiModelProperty(value="字典编号")
    private Integer positionalId;

    /**
     * 字典值
     */
    @TableField(value = "positional_name")
    @ApiModelProperty(value="字典值")
    private String positionalName;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 是否有子节点
     */
    @TableField(value = "child_node")
    @ApiModelProperty(value="是否有子节点")
    private Integer childNode;

    private static final long serialVersionUID = 1L;
}