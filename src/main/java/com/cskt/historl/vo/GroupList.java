package com.cskt.historl.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description: 会诊列表
 * @author: Mr.阿九
 * @createTime: 2021-02-20 17:56
 **/
@Data
public class GroupList {

    @TableField(value = "id")
    private Integer id;
    @TableField(value = "sufferer_name")
    private String suffererName;
    @TableField(value = "sufferer_age")
    private Integer suffererAge;
    @TableField(value = "sufferer_sex")
    private Integer suffererSex;
    @TableField(value = "appointment_time")
    private Date appointmentTime;
    @TableField(value = "state")
    private Integer state;
    @TableField(value = "department_name")
    private String departmentName;
    @TableField(value = "group_doctor_mobile")
    private String groupDoctorMobile;
}
