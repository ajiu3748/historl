package com.cskt.historl.constants;

import lombok.Getter;

/**
 * 作者：LSH
 * 日期：2020/1/6 20:41
 * 返回码枚举类
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(true, 20000,"成功"),
    LONGIN_FAILED(false,20002,"登陆失败"),
    UNKNOWN_REASON(false, 20001, "未知错误"),
    BAD_SQL_GRAMMAR(false, 21001, "sql语法错误"),
    JSON_PARSE_ERROR(false, 21002, "json解析异常"),
    PARAM_ERROR(false, 21003, "参数不正确"),
    FILE_UPLOAD_ERROR(false, 21004, "文件上传错误"),
    EXCEL_DATA_IMPORT_ERROR(false, 21005, "Excel数据导入错误"),
    USERLOGIN_INVALID_ERROR(false,21007,"登陆信息已过期"),
    USERLOGIN_ERROR(false,21008,"用户未登陆，请重新登陆"),
    VIDEO_UPLOAD_ALIYUN_ERROR(false, 21009,"视频上传云服务器失败"),
    VIDEO_UPLOAD_TOMCAT_ERROR(false, 21010,"视频上传缓存服务器失败"),
    VIDEO_DELETE_ALIYUN_ERROR(false, 21011,"视频删除失败"),
    REFRESH_VIDEO_PLAYAUTH_ERROR(false,21012,"刷新上传凭证失败"),
    FETCH_PLAYAUTH_ERROR(false,21013,"获取凭证失败"),
    URL_CODE_ERROR(false,21014,"URL转码异常");

    private Boolean success;

    private Integer code;

    private String message;

    private ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
