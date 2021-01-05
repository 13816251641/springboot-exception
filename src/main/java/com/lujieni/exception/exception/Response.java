package com.lujieni.exception.exception;

import java.io.Serializable;

/**
 * @Package: com.lujieni.exception.exception
 * @ClassName: Response
 * @Author: lujieni
 * @Description: 全局返回实体类
 * @Date: 2021-01-05 11:23
 * @Version: 1.0
 */
public class Response<T> implements Serializable {

    public static final String ERROR_REDIRECT = "302";
    public static final String ERROR_CODE_NOT_RIGHT_TO_ACCESS = "403";
    public static final String ERROR_CODE_VALIDATE = "10000";
    public static final String ERROR_CODE_BUSINESS_EXCEPTION = "20000";
    public static final String ERROR_CODE_UNHANDLED_EXCEPTION = "90000";
    private String requestId;
    private boolean success;
    private boolean hasBusinessException;
    private String errorCode;
    private String errorMsg;
    private String message;
    private T result;

    public Response() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isHasBusinessException() {
        return this.hasBusinessException;
    }

    public void setHasBusinessException(boolean hasBusinessException) {
        this.hasBusinessException = hasBusinessException;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public static Response buildNoRightToAccessResponse(String errorMessage) {
        Response result = new Response();
        result.setSuccess(false);
        result.setHasBusinessException(true);
        result.setErrorCode("403");
        result.setErrorMsg(errorMessage);
        result.setMessage(errorMessage);
        return result;
    }


}