package com.lujieni.exception.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 异常处理器
 */
/*
    @RestControllerAdvice
    @Slf4j
    public class GlobalExceptionHandler {

        *//*
            @ExceptionHandler(DuplicateKeyException.class)
            public void handleDuplicateKeyException(DuplicateKeyException e){
                log.error("数据库中已存在该记录", e);
            }
        *//*


        @ExceptionHandler(IllegalArgumentException.class)
        public void handleIllegalArgumentExceptionException(IllegalArgumentException e){
            log.error(e.getMessage(), e);
        }

        @ExceptionHandler(Exception.class)
        public void handleException(Exception e,HttpServletRequest httpRequest){
            log.error("全局异常", e);
        }

        *//**
         *  校验错误拦截处理
         *
         * @param exception 错误信息集合
         * @return 错误信息
         *//*
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public void validationBodyException(MethodArgumentNotValidException exception){
            BindingResult result = exception.getBindingResult();
            if (result.hasErrors()) {
                List<ObjectError> errors = result.getAllErrors();

                errors.forEach(p ->{
                    FieldError fieldError = (FieldError) p;
                    log.error("Data check failure : object:{},field:{},errorMessage:{}"
                            ,fieldError.getObjectName(),fieldError.getField(),fieldError.getDefaultMessage());
                });
            }
        }

        *//**
         * 参数类型转换错误
         *
         * @param exception 错误
         * @return 错误信息
         *//*
        @ExceptionHandler(HttpMessageConversionException.class)
        public void parameterTypeException(HttpMessageConversionException exception){
            log.error("类型转换错误",exception);
        }

        *//**
         * 不支持请求异常
         * @param exception
         * @return
         *//*
        @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
        public void httpRequestMethodNotSupportedExceptionException(HttpRequestMethodNotSupportedException exception){
            log.error("不支持请求类型",exception);
        }
}*/
