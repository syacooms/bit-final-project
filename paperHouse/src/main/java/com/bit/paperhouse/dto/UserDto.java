package com.bit.paperhouse.dto;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;


/*
    CREATE TABLE USERTABLE2(
  ID VARCHAR2(100) PRIMARY KEY,
  PASSWORD CHAR(60) NOT NULL,
  NAME VARCHAR2(45) NOT NULL,
  AUTHORITY VARCHAR2(50) NOT NULL,
  ENABLED NUMBER(1) NOT NULL
  )

 */

public class UserDto implements Serializable {

    private int user_seq;
	private String email;
	private String pwd;
	private String nickName;
	private String authority;
	private String enabled;

	public UserDto() {

	}
	

	public UserDto(String email, String pwd, String nickName, String authority) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.nickName = nickName;
		this.authority = authority;
	}



	public UserDto(int user_seq, String email, String nickName, String authority, String enabled) {
		super();
		this.user_seq = user_seq;
		this.email = email;
		this.nickName = nickName;
		this.authority = authority;
		this.enabled = enabled;
	}


	public UserDto(int user_seq, String email, String pwd, String nickName, String authority, String enabled) {
		super();
		this.user_seq = user_seq;
		this.email = email;
		this.pwd = pwd;
		this.nickName = nickName;
		this.authority = authority;
		this.enabled = enabled;
	}


	public int getUser_seq() {
		return user_seq;
	}



	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public String getNickName() {
		return nickName;
	}



	public void setNickName(String nickName) {
		this.nickName = nickName;
	}



	public String getAuthority() {
		return authority;
	}



	public void setAuthority(String authority) {
		this.authority = authority;
	}



	public String getEnabled() {
		return enabled;
	}



	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}



	@Override
	public String toString() {
		return "UserDto [email=" + email + ", pwd=" + pwd + ", nickName=" + nickName + ", authority=" + authority
				+ ", enabled=" + enabled + "]";
	}
	
	
	
	
	

	


}
