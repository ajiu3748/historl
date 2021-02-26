package com.cskt.historl.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description: 申请转诊类
 * @author: Mr.阿九
 * @createTime: 2021-02-22 12:01
 **/
@Data
public class ApplyRefer {

    /**
     * 会诊
     */
    @TableField(value = "id")
    @ApiModelProperty(value="会诊")
    private Integer id;

    /**
     * 申请状态
     */
    @TableField(value = "state")
    @ApiModelProperty(value="申请状态")
    private Integer state;

    /**
     * 医生id
     */
    @TableField(value = "doctor_id")
    @ApiModelProperty(value="医生id")
    private Integer doctorId;

    /**
     * 接诊医生姓名
     */
    @TableField(value = "group_doctor")
    @ApiModelProperty(value="接诊医生姓名")
    private String groupDoctor;

    /**
     * 科室id
     */
    @TableField(value = "department_id")
    @ApiModelProperty(value="科室id")
    private Integer departmentId;
    /**
     * 分诊建议
     */
    @TableField(value = "group_remark")
    @ApiModelProperty(value="分诊建议")
    private String groupRemark;

    /**
     * 拒绝理由
     */
    @TableField(value = "status_remark")
    @ApiModelProperty(value="拒绝理由")
    private String statusRemark;

    /**
     * 医院id
     */
    @TableField(value = "hospital_id")
    @ApiModelProperty(value="医院id")
    private Integer hospitalId;

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
     * 门诊类型
     */
    @TableField(value = "Outpatient_type")
    @ApiModelProperty(value="门诊类型")
    private Integer outpatientType;

    /**
     * 备注
     */
    @TableField(value = "remarks")
    @ApiModelProperty(value="备注")
    private String remarks;


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
     * 修改时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

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
}
