package com.example.demo.application.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {
	private String userId;
	private String password;
	private String userName;
	
	// 指定のフォーマットで入力を受け取ることで、入力値をDate型にバインド可能
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date birthday;
	
	private int age;
	private int gender;
	
}
