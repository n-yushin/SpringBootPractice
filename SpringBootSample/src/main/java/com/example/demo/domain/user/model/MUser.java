package com.example.demo.domain.user.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MUser {
	private String userId;
	private String password;
	private String userName;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date birthday;
	private Integer age;
	private Integer gender;
	private Integer departmentId;
	private String role;
}
