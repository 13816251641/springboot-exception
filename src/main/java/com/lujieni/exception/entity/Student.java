package com.lujieni.exception.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@Accessors(chain = true)
/*
    @NotEmpty 用在集合类上面
    加了@NotEmpty的String类、Collection、Map、数组，是不能为null或者长度为0的(String Collection Map的isEmpty()方法)

    @NotBlank只用于String,不能为null且trim()之后size>0

    @NotNull:不能为null，但可以为empty,没有Size的约束

    @Length(min = 1, max = 5, message = "name的长度为1到5")可以加在String上但它不校验字符串非空,即使是null
    它也不会报错,所以要配合@NotNull or @NotEmpty or @NotBlank一起用


    @Digits(integer = 2, fraction = 2, message = "abc")
    小数位:最多2位小数  整数位:最多2位整数
    可以加在Integer Float 等数字类型上但它不校验字符串非空,即使是null
    它也不会报错,所以要配合@NotNull一起用

    @DecimalMin 设置不能超过最小值
    可以加在Integer Float 等数字类型上但它不校验字符串非空,即使是null
    它也不会报错,所以要配合@NotNull一起用

    @Pattern(regexp = "CBM",message = "名字必须是CBM") 正则校验, 全匹配!!!
    可以加在String上但它不校验字符串非空,即使是null
    它也不会报错,所以要配合@NotNull or @NotEmpty or @NotBlank一起用

 */
public class Student {
    @NotNull(message = "年龄不能为空哦")
    @Digits(integer = 2, fraction = 2, message = "整数位最多2位,小数位最多2位")
    @DecimalMin(value = "10", message = "最小值为10")
    private Float age;
    @NotBlank(message = "名字不能为空哦")
    @Length(min = 1, max = 5, message = "名字长度为1到5")
    @Pattern(regexp = "CBM",message = "名字必须是CBM")
    private String name;
    private Date date;
}
