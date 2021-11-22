package com.example.demo.application.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.application.form.SignupForm;
import com.example.demo.application.service.UserApplicationService;

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
	public String posetSignUp(@ModelAttribute SignupForm form) {
		log.info(form.toString());
		// ログイン画面にリダイレクト
		return "redirect:/login";
	}
}
