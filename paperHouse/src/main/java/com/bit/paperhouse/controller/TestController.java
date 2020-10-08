package com.bit.paperhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bit.paperhouse.dto.UserDto;
import com.bit.paperhouse.service.UserService;

@Controller
public class TestController {

	@Autowired
	UserService svc;

	// 메인 페이지
	@GetMapping("/")
	public String index() {
		return "/index";
	}

	// 회원가입 페이지
	@GetMapping("/user/join")
	public String dispJoin() {
		return "/join";
	}

	// 회원가입 처리
	@PostMapping("/user/join")
	public String execSignup(UserDto UserDto) {
		svc.regi(UserDto);
		return "redirect:/user/login";
	}

	// 로그인 페이지
	@GetMapping("/user/login")
	public String dispLogin() {
		System.out.println("Login");
		return "/login";
	}

	// 로그인 결과 페이지
	@GetMapping("/user/login/result")
	public String dispLoginResult() {
		System.out.println("Login result");
		return "/main";
	}

	// 로그아웃 결과 페이지
	@GetMapping("/user/logout/result")
	public String dispLogout() {
		return "redirect:/";
	}

}
