package com.bit.paperhouse.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto implements Serializable {

	private int writer_seq;
	private int article_seq;
	private String title;
	private String cont;
	private String upload_date;
	private int viewcount;
	private int likes;
	private String categorys;
	private String file_original;
	private String file_system;
	
}
