  
package com.bit.paperhouse.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor 
@AllArgsConstructor

public class WriterDto implements Serializable {

	private int userSeq;
	private int writerSeq;
	private String writerName;
	private String email;
	private String intro;
	private String fileOriginalName;
	private String fileSystem;
	private int status;
	
	//user subscribe dto 대신 writerDto 사용
	private String startDate;
	private String endDate;
	
	
}