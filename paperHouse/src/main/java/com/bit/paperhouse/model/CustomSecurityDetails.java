package com.bit.paperhouse.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomSecurityDetails implements Serializable, UserDetails {
	
	private int USER_SEQ;
	private String EMAIL;
	private String PWD;
	private String NICKNAME;
	private String AUTHORITY;     // 권한
	private boolean ENABLED;      // 접근 가능 여부 체크
	
	public CustomSecurityDetails() {
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		 ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
	      auth.add(new SimpleGrantedAuthority(AUTHORITY));
			
			return auth;
	}

	@Override
	public String getPassword() {
		
		return PWD;
	}

	@Override
	public String getUsername() {
		
		return EMAIL;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
