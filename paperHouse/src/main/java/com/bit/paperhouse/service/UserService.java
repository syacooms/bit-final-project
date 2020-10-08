package com.bit.paperhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bit.paperhouse.dao.UserRepository;
import com.bit.paperhouse.dto.UserDto;


@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository dao;

	@Autowired
	PasswordEncoder bCryptPasswordEncoder;


	public void regi( UserDto dto ) {
		
		String rPwd = dto.getPwd();
		String securityPwd = bCryptPasswordEncoder.encode(rPwd);
		dto.setAuthority("ROLE_USER");
		dto.setPwd(securityPwd);
		dto.setNickname("화려한유니콘654");
		 dao.regi(dto);
	}


}
