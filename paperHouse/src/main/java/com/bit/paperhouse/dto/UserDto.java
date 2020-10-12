package com.bit.paperhouse.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
	
<<<<<<< HEAD
	private int user_seq;
=======
	private int userSeq;
>>>>>>> 863a53c6d3e3945bf3f34585b384217b243bf7e6
	private String email;
	private String pwd;
	private String nickname;
	private String authority;
	private int enabled;
	
}
