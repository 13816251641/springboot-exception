package com.lujieni.exception.exception;

import java.io.Serializable;

/**
 * @Package: com.lujieni.exception.exception
 * @ClassName: BusinessException
 * @Author: lujieni
 * @Description: 业务异常
 * @Date: 2021-01-05 11:43
 * @Version: 1.0
 */
public class BusinessException extends RuntimeException implements Serializable {

    /**
     * 异常国际化编码
     */
    protected String errCode;

    /**
     * 异常参数
     */
    private Object[] arguments;

    public BusinessException() {
    }

    public BusinessException(String msg) {
        super(msg);
        this.errCode = msg;
    }

    public BusinessException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BusinessException(String code, String msg) {
        super(msg);
        this.errCode = code;
    }

    public BusinessException(String code, String msg, Throwable cause) {
        super(msg, cause);
        this.errCode = code;
    }

    public BusinessException(String code, Object... args) {
        this.errCode = code;
        this.arguments = args;
    }

    public BusinessException(String code, String msg, Object... args) {
        super(msg);
        this.errCode = code;
        this.arguments = args;
    }

    public BusinessException(Throwable throwable) {
        super(throwable);
    }

    public void setErrorArguments(Object... args) {
        this.arguments = args;
    }

    public Object[] getErrorArguments() {
        return this.arguments;
    }

    public String getErrorCode() {
        return this.errCode;
    }

}