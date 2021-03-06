package com.bit.paperhouse.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;


// 로그인 실패시 메시지 뿌려주는 곳
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private final String DEFAULT_FAILURE_URL = "/user/login?error=true";

	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		String errorMessage = null;
		
	
		if(exception instanceof BadCredentialsException || exception instanceof InternalAuthenticationServiceException) {
			errorMessage = "이메일 인증을 하지 않았거나 아이디 또는 비밀번호가 맞지 않습니다. 다시 확인해 주십시오.";
		}
	
		else if(exception instanceof DisabledException) {
			errorMessage = "이메일 인증이 필요합니다. 가입하실 때 입력하신 이메일을 확인해주세요";
		}
		
		else if(exception instanceof CredentialsExpiredException) {
			errorMessage = "비밀번호 유효기간이 만료 되었습니다. 관리자에게 문의하세요.";
		}
		else {
			errorMessage = "알수 없는 이유로 로그인에 실패하였습니다. 관리자에게 문의하세요.";
		}
		
	
		request.setAttribute("errorMessage", errorMessage);
	
		request.getRequestDispatcher(DEFAULT_FAILURE_URL).forward(request, response);
		
		
	}
	
	
}
	
	
	


