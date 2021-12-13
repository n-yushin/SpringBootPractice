package com.example.demo.domain.user.model;

import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class MUser {
	private String userId;
	private String password;
	private String userName;
	private Date birthday;
	private Integer age;
	private Integer gender;
	private Integer departmentId;
	private String role;
	// 部署マスタオブジェクト
	private Department department;
	// 給料テーブル（ユーザに対して複数項目あるのでListで定義する）
	private List<Salary> salaryList;
}
