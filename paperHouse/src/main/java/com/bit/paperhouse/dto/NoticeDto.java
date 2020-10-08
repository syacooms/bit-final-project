package com.bit.paperhouse.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDto implements Serializable {
	private int notice_seq;
	private String title;
	private String cont;
	private String upload_date;
	private String file_original;
	private String file_system;
	private int viewcount;
	private int del;
}
