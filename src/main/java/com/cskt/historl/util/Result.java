package com.cskt.historl.util;

import lombok.Data;

@Data
public class Result<T> {
    /**
     *成功标志
     */
    private boolean success =true;
    /**
     *返回处理消息
     */
    private String message ="操作成功";
    /**
     * 返回消息的状态码
     */
    private int code=0;
    /**
     * 返回的数据
     */
    private T result;

}
