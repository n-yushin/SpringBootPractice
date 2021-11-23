package com.example.demo.application.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {
	@NotBlank(groups = ValidGroup1.class)
	@Email(groups = ValidGroup2.class)
	private String userId;
	
	@NotBlank(groups = ValidGroup1.class)
	@Length(min=4, max=100, groups = ValidGroup2.class)
	@Pattern(regexp="^[a-zA-z0-9]+$", groups = ValidGroup2.class)
	private String password;
	
	@NotBlank(groups = ValidGroup1.class)
	private String userName;
	
	// 指定のフォーマットで入力を受け取ることで、入力値をDate型にバインド可能
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@NotNull(groups = ValidGroup1.class)
	private Date birthday;
	
	@Min(value=20, groups=ValidGroup2.class)
	@Max(value=100, groups=ValidGroup2.class)
	private int age;
	
	@NotNull(groups = ValidGroup1.class)
	private int gender;
	
}
