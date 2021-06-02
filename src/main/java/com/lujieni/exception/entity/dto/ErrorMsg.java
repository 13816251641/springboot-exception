package com.lujieni.exception.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("错误消息")
public class ErrorMsg implements Serializable{

    private static final long serialVersionUID = -666260896003710606L;

    @ApiModelProperty("部分失败时存放失败的明细记录id")
    private String id;

    @ApiModelProperty("错误消息编码")
    private String  code;

    @ApiModelProperty("错误消息描述")
    private String message;

    public ErrorMsg() {}

    public ErrorMsg(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorMsg(String id, String code, String message) {
        this.id = id;
        this.code = code;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorMsg{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
