  
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
<<<<<<< HEAD
	private String email;
=======
>>>>>>> writer-fnc
	private String intro;
	private String history;
	private String profileFileOriginal;
	private String profileFileSystem;
	private String fileOriginal;
	private String fileSystem;
	private String publicRelations;
	private int status;
	
	//user subscribe dto 대신 writerDto 사용
	private String startDate;
	private String endDate;
	
}