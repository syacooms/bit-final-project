  
package com.bit.paperhouse.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
public class WriterDto implements Serializable {

	private int user_seq;
	private int writer_seq;
	private String name;
	private String email;
	private String intro;
	private String fileoriginal_name;
	private String file_system;
	private int status;
	
	//user subscribe dto 대신 writerDto 사용
	private String start_date;
	private String end_date;
	
}