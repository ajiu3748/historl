package com.cskt.historl.exception;


import com.cskt.historl.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 作者：LSH
 * 日期：2020/1/7 19:32
 */
@Data
@ApiModel(value = "全局异常")
public class KetaiException extends RuntimeException{
    @ApiModelProperty(value = "状态码")
    private Integer code;

    /**
     * 接受状态码和消息
     * @param code
     * @param message
     */
    public KetaiException(Integer code, String message) {
        super(message);
        this.code=code;
    }

    /**
     * 接收枚举类型
     * @param resultCodeEnum
     */
    public KetaiException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "KetaiException{" +
                "message=" + this.getMessage() +
                ", code=" + code +
                '}';
    }
}
