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
    * 转诊申请
    */
@ApiModel(value="com-referral-referralbackstage-entity-Referral")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "referral")
public class Referral implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
     * 医生id
     */
    @TableField(value = "doctor_id")
    @ApiModelProperty(value="医生id")
    private Integer doctorId;

    /**
     * 医院id
     */
    @TableField(value = "hospital_id")
    @ApiModelProperty(value="医院id")
    private Integer hospitalId;

    /**
     * 科室id
     */
    @TableField(value = "department_id")
    @ApiModelProperty(value="科室id")
    private Integer departmentId;

    /**
     * 预约时间
     */
    @TableField(value = "appointment_time")
    @ApiModelProperty(value="预约时间")
    private String appointmentTime;

    /**
     * 患者详情id
     */
    @TableField(value = "sufferer_details_id")
    @ApiModelProperty(value="患者详情id")
    private Integer suffererDetailsId;

    /**
     * 备注
     */
    @TableField(value = "remarks")
    @ApiModelProperty(value="备注")
    private String remarks;

    /**
     * 门诊类型
     */
    @TableField(value = "Outpatient_type")
    @ApiModelProperty(value="门诊类型")
    private Integer outpatientType;

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
     * 申请状态
     */
    @TableField(value = "state")
    @ApiModelProperty(value="申请状态")
    private Integer state;

    /**
     * 拒绝理由
     */
    @TableField(value = "status_remark")
    @ApiModelProperty(value="拒绝理由")
    private String statusRemark;

    /**
     * 主诉
     */
    @TableField(value = "chief_complaint")
    @ApiModelProperty(value="主诉")
    private String chiefComplaint;

    /**
     * 查体
     */
    @TableField(value = "physical_examination")
    @ApiModelProperty(value="查体")
    private String physicalExamination;

    /**
     * 待解问题
     */
    @TableField(value = "problem_to_be_solved")
    @ApiModelProperty(value="待解问题")
    private String problemToBeSolved;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 操作人
     */
    @TableField(value = "operator")
    @ApiModelProperty(value="操作人")
    private String operator;

    /**
     * 转诊医生
     */
    @TableField(value = "group_doctor")
    @ApiModelProperty(value="转诊医生")
    private String groupDoctor;

    /**
     * 转诊时间
     */
    @TableField(value = "group_time")
    @ApiModelProperty(value="转诊时间")
    private Date groupTime;

    /**
     * 转诊建议
     */
    @TableField(value = "group_remark")
    @ApiModelProperty(value="转诊建议")
    private String groupRemark;

    /**
     * 拒绝时间
     */
    @TableField(value = "refuse_time")
    @ApiModelProperty(value="拒绝时间")
    private Date refuseTime;

    /**
     * 完成时间
     */
    @TableField(value = "complete_time")
    @ApiModelProperty(value="完成时间")
    private Date completeTime;

    private static final long serialVersionUID = 1L;
}