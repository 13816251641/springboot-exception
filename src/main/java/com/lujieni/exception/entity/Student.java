package com.lujieni.exception.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
/*
    @NotEmpty 也可以用在集合类上面
    加了@NotEmpty的String类、Collection、Map、数组，能检测为null或者长度为0的(String Collection Map的isEmpty()方法),因此
    不需要和@NotNull搭配使用

    @NotBlank只用于String,字段不能为null且trim()之后size>0,不需要和@NotNull搭配使用

    @NotNull:不能为null，但可以为empty,没有Size的约束

    @Length(min = 1, max = 5, message = "name的长度为1到5")只能加在String上但它不校验字符串非空,即使是null
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
    @NotNull(message = "{age.isNull}")
    @Range(min = 1L,max = 130L,message = "age必须介于1-130之间")
    private Integer age;

    @NotBlank(message = "name不能为空")
    @Length(max =30,message = "name最大为30个字符")
    private String name;

}
