package com.bit.paperhouse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration.ProviderDetails.UserInfoEndpoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.bit.paperhouse.service.PrincipalOauth2UserService;

// 1.코드받기(인증) 2.엑세스토큰(권한) 
//3.사용자프로필 정보를 가져오고 4.그 정보를 토대로 회원강비을 자동으로 진행시키기도 함
//4-2.(이메일,전화번호, 이름, 아이디)쇼핑몰 ->(집주소), 백화점몰 -> (vip등급, 일반등급)

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PrincipalOauth2UserService principalOauth2UserService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// http.csrf().disable().httpBasic();
		http.authorizeRequests()
			.antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/**").permitAll()
		.and()
			.formLogin()
	        .loginPage("/user/login")
	        .defaultSuccessUrl("/user/login/result")
	        .permitAll()
		.and()
			.logout()
	        .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
	        .logoutSuccessUrl("/user/logout/result")
	        .invalidateHttpSession(true)
	        .and()
	        .oauth2Login()
	        .defaultSuccessUrl("/user/login/oauth2/result")
	        .loginPage("/user/login") 
		    .userInfoEndpoint()
		    .userService(principalOauth2UserService);//구글 로그인 된 뒤 후처리가 필요함  Tip.코드x (엑세스토큰+사용자프로필정보 O)
		
		http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true); // 동시 로그인 불가
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

}
