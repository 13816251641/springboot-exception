package com.lujieni.exception.exception;

/**
 * @Package: com.lujieni.exception.exception
 * @ClassName: AccessNotAllowException
 * @Author: lujieni
 * @Description: 访问拒绝异常
 * @Date: 2021-01-05 11:37
 * @Version: 1.0
 */
public class AccessNotAllowException extends RuntimeException {

    /**
     * 异常信息国际化编码
     */
    private String errCode;

    /**
     * 默认国际化编码
     */
    public static final String ERROR_CODE = "error.user.no.right.to.access";

    /**
     * 默认异常提示内容
     */
    public static final String MESSAGE = "Method not allow access";

    public AccessNotAllowException() {
        this(MESSAGE);
        this.errCode = ERROR_CODE;
    }

    public AccessNotAllowException(String msg) {
        super(msg);
        this.errCode = ERROR_CODE;
    }

    public String getErrorCode() {
        return this.errCode;
    }


}