package com.bit.paperhouse.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    
    // 로그인 페이지
    @RequestMapping(value="/user/login", method = {RequestMethod.POST, RequestMethod.GET})
    public String dispLogin( boolean error, HttpServletRequest request, Model model) {
    	System.out.println("Login");
    	String noError = "";
    	if( error == true) {
    		String errorMessage = (String)request.getAttribute("errorMessage");
    		model.addAttribute("errorMessage", errorMessage);
    	}else {
    		model.addAttribute("errorMessage" , noError);
    	}
    	
        return "/login";
    }
   
    /*
    @GetMapping("/user")
    public @ResponseBody String user( @AuthenticationPrincipal CustomSecurityDetails customSecurityDetails) {
    	System.out.println("CustomSecurityDetails : " + customSecurityDetails.getEMAIL());
    	
    	return "/loginAf";
    }
    */
   
    @GetMapping("/main")
    public String socialLoginAf() {
    	//CustomSecurityDetails user = (CustomSecurityDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	//System.out.println("seq : " + user.getUSERSEQ());
    	return "/main";
    }
    
 // 소셜 로그인 결과 페이지
    @GetMapping("/user/login/oauth2/result")
    public String oauth2Login() {
    	System.out.println("oauth2Login result");
    	
        return "/loginAf";
    }

	// 회원가입 페이지
	@GetMapping("/user/join")
	public String dispJoin() {
		return "/join";
	}

	// 회원가입 처리
	@PostMapping("/user/join")
	public void execSignup(UserDto UserDto) {
		svc.regi(UserDto);
		
	}

	// 로그인 결과 페이지
	@RequestMapping(value="/user/login/result", method = {RequestMethod.POST, RequestMethod.GET})
	public String dispLoginResult() {
		System.out.println("Login result");
		return "/main";
	}

	// 로그아웃 결과 페이지
	@GetMapping("/user/logout/result")
	public String dispLogout() {
		return "redirect:/";
	}
	
	// 임시 비밀번호 설정 페이지
	@GetMapping("/user/passwordReset")
	public String resetPasswordView() {
		return "/passwordReset";
	}
	
	// 임시 비밀번호 설정
	@RequestMapping( value = "/user/resetPassword/result" , method = RequestMethod.POST)
	public @ResponseBody void resetPassword( UserDto dto ) {
		
		
		System.out.println("비밀번호 재설정");
		svc.resetPassword(dto);
	}
	

	
}
