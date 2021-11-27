package com.example.demo.domain.user.service;

import java.util.List;

import com.example.demo.domain.user.model.MUser;

public interface UserService {

	/** ユーザー登録 */
	public void signUp(MUser user);
	
	/** ユーザー取得 */
	public List<MUser> getUsers();
}
