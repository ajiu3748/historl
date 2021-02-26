package com.cskt.historl.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @description: 申请会诊医生信息
 * @author: Mr.阿九
 * @createTime: 2021-02-20 19:07
 **/
@Data
public class ApplyHName {
    /**
     * 科室id
     */
    @TableField(value = "department_id")
    @ApiModelProperty(value="科室id")
    private Integer departmentId;
    /**
     * 医院id
     */
    @TableField(value = "hospital_id")
    @ApiModelProperty(value="医院id")
    private Integer hospitalId;
    /**
     * 用户名称
     */
    @TableField(value = "user_name")
    @ApiModelProperty(value="用户名称")
    private String userName;
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
}
