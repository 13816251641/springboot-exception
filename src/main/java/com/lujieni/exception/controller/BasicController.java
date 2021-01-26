package com.lujieni.exception.controller;

import com.lujieni.exception.exception.AccessNotAllowException;
import com.lujieni.exception.exception.BusinessException;
import com.lujieni.exception.exception.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package: com.lujieni.exception.controller
 * @ClassName: BasicController
 * @Author: lujieni
 * @Description: 基础控制器
 * @Date: 2021-01-05 11:32
 * @Version: 1.0
 */
//@ControllerAdvice 不加的前提是业务Controller要继承BasicController
public class BasicController {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());


    public BasicController() {
    }

    public Response returnSuccess() {
        return this.returnSuccess((String)null);
    }

    public Response returnSuccess(String successMsg) {
        return this.returnSuccess((Object)null, successMsg);
    }

    public Response returnSuccess(Object object) {
        return this.returnSuccess(object, (String)null);
    }

    public Response returnSuccess(Object object, String successMsg) {
        Response response = new Response();
        response.setSuccess(true);
        response.setHasBusinessException(false);
        response.setMessage(successMsg);
        response.setResult(object);
        return response;
    }

    /*
        给controller主动调用的
     */
    public Response returnValidateError(String errorMsg) {
        Response response = new Response();
        response.setSuccess(false);
        response.setHasBusinessException(true);
        response.setErrorCode("10000");
        response.setMessage(errorMsg);
        response.setErrorCode("10000");
        response.setErrorMsg(errorMsg);
        return response;
    }

    /*
        给controller主动调用的
    */
    public Response returnValidateError(BindingResult bindingResult) {
        Response response = new Response();
        response.setSuccess(false);
        response.setHasBusinessException(true);
        StringBuffer errorMsg = new StringBuffer();
        bindingResult.getFieldErrors().forEach((fieldError) -> {
            errorMsg.append(fieldError.getDefaultMessage()).append("\n");
        });
        response.setMessage(errorMsg.toString());
        response.setErrorCode("10000");
        response.setErrorMsg(errorMsg.toString());
        return response;
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody //不加也可以
    public Response handlerException(Exception exception) {
        this.log.error(exception.getMessage(), exception);
        Response response = new Response();
        response.setSuccess(false);
        if (exception instanceof AccessNotAllowException) {
            response = Response.buildNoRightToAccessResponse(((AccessNotAllowException)exception).getErrorCode());
        } else if (exception instanceof BusinessException) {
            response.setHasBusinessException(true);
            response.setMessage(((BusinessException)exception).getMessage());
            response.setErrorCode("20000");
            response.setErrorMsg(((BusinessException)exception).getMessage());
        } else if (exception instanceof MethodArgumentNotValidException) { //校验错误拦截处理
            response.setHasBusinessException(true);
            BindingResult bindingResult = ((MethodArgumentNotValidException)exception).getBindingResult();
            StringBuffer errorMsg = new StringBuffer();
            bindingResult.getFieldErrors().forEach((fieldError) -> {
                errorMsg.append(fieldError.getDefaultMessage()).append(";");
            });
            response.setMessage(errorMsg.toString());
            response.setErrorCode("10000");
            response.setErrorMsg(errorMsg.toString());
        } else {
            response.setHasBusinessException(false);
            response.setMessage("系统异常:"+exception.getMessage());
            response.setErrorCode("90000");
        }

        return response;
    }

}