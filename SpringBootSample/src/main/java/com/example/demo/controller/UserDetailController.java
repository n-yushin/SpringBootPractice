package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.form.UserDetailForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserDetailController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/** ユーザー詳細画面を表示 */
	@GetMapping("/detail/{userId:.+}")
	public String getUser(UserDetailForm form, Model model, @PathVariable("userId") String userId) {
		
		// ユーザー情報を取得
		MUser user = userService.getUserOne(userId);
		user.setPassword(null);
		
		// MUserをformに変換
		form = modelMapper.map(user, UserDetailForm.class);
		form.setSalaryList(user.getSalaryList());
		
		// Modelに登録
		model.addAttribute("userDetailForm", form);
		
		// ログ
		log.info("MUserの中身："+user.toString());
		
		// ユーザー詳細画面を表示
		return "user/detail";
	}
	
	/** ユーザー更新（一件） */
	// パラメータはparams要素で渡すんですね
	@PostMapping(value="/detail", params="update")
	public String updateUser(UserDetailForm form, Model model) {
		
		try {
			userService.updateUserOne(form.getUserId(), form.getPassword(), form.getUserName());
		}catch (Exception e) {
			log.error("ユーザー更新でエラー");
			log.error(e.toString());
		}
		return "redirect:/user/list";
	}
	
	/** ユーザー削除（一件） */
	@PostMapping(value="/detail", params="delete")
	public String deleteUser(UserDetailForm form, Model model) {
		userService.deleteUserOne(form.getUserId());
		
		return "redirect:/user/list";
	}
}
