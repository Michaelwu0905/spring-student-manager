package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class StudentDTO {

    private Long id;

    @NotBlank(message = "姓名不能为空")
    @Size(max = 50, message = "姓名长度不能超过50")
    private String name;

    @NotBlank(message = "学号不能为空")
    @Size(max = 20, message = "学号长度不能超过20")
    private String studentNo;

    private String gender;

    @Min(value = 1, message = "年龄必须大于0")
    @Max(value = 150, message = "年龄不能超过150")
    private Integer age;

    @Size(max = 100, message = "专业长度不能超过100")
    private String major;

    @Size(max = 50, message = "班级长度不能超过50")
    private String className;

    @Email(message = "邮箱格式不正确")
    private String email;
}