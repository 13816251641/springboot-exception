package com.lujieni.exception.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @Title: ResponseVO
 * @Package com.hoau.cancer.common.server.vo
 * @Description: Cancer后台响应实体
 * @author 于金谷
 * @date 2017/9/21 09:53
 * @version V1.0
 */
@ApiModel("接口公共后台响应实体")
public class ResponseDTO <T> implements Serializable {
    private static final long serialVersionUID = -844795352633980897L;

    @ApiModelProperty(value = "返回码, 0=成功")
    private String code;

    @ApiModelProperty(value = "返回描述信息")
    private String message;

    @ApiModelProperty(value = "是否成功, true=成功, false=失败")
    private boolean success;

    @ApiModelProperty(value = "返回业务数据对象")
    private T data;

    @ApiModelProperty(value = "错误信息列表")
    private List<ErrorMsg> errors;

    @ApiModelProperty(value = "请求ID")
    private String messageId;

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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<ErrorMsg> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorMsg> errors) {
        this.errors = errors;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public ResponseDTO(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResponseDTO() {
    }


    public static ResponseDTO buildFailedRsponseDTO(String messageId, List<ErrorMsg> errors) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccess(false);
        responseDTO.setCode("4");
        responseDTO.setMessage("ALL data failed");
        responseDTO.setMessageId(messageId);
        responseDTO.setErrors(errors);
        return responseDTO;
    }

    public static ResponseDTO buildFailedRsponseDTO(String messageId, String errorCode, String errorMsg) {
        List<ErrorMsg> errors = new ArrayList<ErrorMsg>() {{
            add(new ErrorMsg(errorCode, errorMsg));
        }};
        return buildFailedRsponseDTO(messageId,errors);
    }
    public static ResponseDTO buildSuccessRsponseDTO(String messageId) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccess(true);
        responseDTO.setCode("0");
        responseDTO.setMessage("Successful");
        responseDTO.setMessageId(messageId);
        return responseDTO;
    }
}
