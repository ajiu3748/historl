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
    * 聊天记录
    */
@ApiModel(value="com-referral-referralbackstage-entity-ChattingRecords")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "chatting_records")
public class ChattingRecords implements Serializable {
    /**
     * 聊天记录id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="聊天记录id")
    private Integer id;

    /**
     * 会诊表id
     */
    @TableField(value = "group_consultation_id")
    @ApiModelProperty(value="会诊表id")
    private Integer groupConsultationId;

    /**
     * 转诊表id
     */
    @TableField(value = "referral_id")
    @ApiModelProperty(value="转诊表id")
    private Integer referralId;

    /**
     * 医生id
     */
    @TableField(value = "doctor")
    @ApiModelProperty(value="医生id")
    private Integer doctor;

    /**
     * 小助手id
     */
    @TableField(value = "little_helper_id")
    @ApiModelProperty(value="小助手id")
    private Integer littleHelperId;

    /**
     * 是否为医生
     */
    @TableField(value = "is_doct")
    @ApiModelProperty(value="是否为医生")
    private Integer isDoct;

    /**
     * 是否已读
     */
    @TableField(value = "have_read")
    @ApiModelProperty(value="是否已读")
    private Integer haveRead;

    /**
     * 消息内容
     */
    @TableField(value = "content")
    @ApiModelProperty(value="消息内容")
    private String content;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}