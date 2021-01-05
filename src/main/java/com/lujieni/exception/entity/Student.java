package com.lujieni.exception.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class Student {
    @NotNull(message = "年龄不能为空哦") // NotBlank NotEmpty 只能适用于String
    private Integer age;
    @NotBlank(message = "名字不能为空哦")
    private String name;
    private Date date;
}
