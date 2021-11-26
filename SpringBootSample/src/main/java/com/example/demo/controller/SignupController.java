package com.example.demo.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.application.service.UserApplicationService;
import com.example.demo.form.GroupOrder;
import com.example.demo.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {
	
	@Autowired
	private UserApplicationService userApplicationService;
	
	/** ユーザ登録画面を表示 */
	@GetMapping("/signup")
	public String getSignUp(Model model, Locale locale, @ModelAttribute SignupForm form) {
		// 性別を登録
		Map<String,Integer> genderMap = userApplicationService.getGenderMap(locale);
		model.addAttribute("genderMap", genderMap);
		
		// ユーザ登録画面に遷移
		return "user/signup";
	}
	
	@PostMapping("/signup")
	public String posetSignUp(Model model, Locale locale, @ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult) {
		// 入力チェック
		if(bindingResult.hasErrors()) {
			// 入力エラーがあった場合、ユーザー情報登録画面に戻る
			return getSignUp(model, locale, form);
		}
		
		log.info(form.toString());
		// ログイン画面にリダイレクト
		return "redirect:/login";
	}
}
