package com.bit.paperhouse.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QnaDto implements Serializable {
	
	private int user_seq;
	private int qna_seq;
	private String title;
	private String conts;
	private String file_original;
	private String file_system;
	private String reply;
	private int status;
}
