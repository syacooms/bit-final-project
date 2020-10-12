package com.bit.paperhouse.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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
	        .invalidateHttpSession(true);
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
