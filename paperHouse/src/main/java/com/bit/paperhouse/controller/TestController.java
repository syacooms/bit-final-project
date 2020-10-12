package com.bit.paperhouse.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bit.paperhouse.dto.UserDto;
import com.bit.paperhouse.model.CustomSecurityDetails;
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

<<<<<<< HEAD
<<<<<<< Updated upstream
	  // 메인 페이지
    @GetMapping("/")
    public String index() {
        return "/index";
    }

=======
>>>>>>> Stashed changes
    // 회원가입 페이지
    @GetMapping("/user/join")
    public String dispJoin() {
        return "/join";
    }

    // 회원가입 처리
<<<<<<< Updated upstream
    @PostMapping("/user/join")
    public String execSignup(UserDto UserDto) {
        svc.regi(UserDto);
        return "redirect:/user/login";
=======
    @PostMapping("/user/join/result")
    public @ResponseBody void execSignup(UserDto UserDto) {
    	System.out.println("aa");
    	svc.regi(UserDto);
      
>>>>>>> Stashed changes
    }
    
    // 로그인 페이지
    @GetMapping("/user/login")
    public String dispLogin() {
    	System.out.println("Login");
        return "/login";
    }
    
<<<<<<< Updated upstream
=======
    @GetMapping("/user")
    public @ResponseBody String user( @AuthenticationPrincipal CustomSecurityDetails customSecurityDetails) {
    	System.out.println("CustomSecurityDetails : " + customSecurityDetails.getEMAIL());
    	return "/loginAf";
    }
    
   
    @GetMapping("/main")
    public String socialLoginAf() {
    	//System.out.println("code : " + code);
    	return "/main";
    }
  
>>>>>>> Stashed changes
    // 로그인 결과 페이지
    @GetMapping("/user/login/result")
    public String dispLoginResult() {
    	System.out.println("Login result");
    	
        return "/main";
    }
<<<<<<< Updated upstream
=======
    
 // 로그인 결과 페이지
    @GetMapping("/user/login/oauth2/result")
    public String oauth2Login() {
    	System.out.println("oauth2Login result");
    	
        return "/loginAf";
    }
>>>>>>> Stashed changes
=======
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

>>>>>>> 863a53c6d3e3945bf3f34585b384217b243bf7e6
}
