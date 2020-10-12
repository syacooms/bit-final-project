package com.bit.paperhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bit.paperhouse.dao.SearchRepository;
import com.bit.paperhouse.dto.ArticleDto;
import com.bit.paperhouse.dto.SearchDto;
import com.bit.paperhouse.dto.WriterDto;

@Service
@Transactional
public class SearchService {

	@Autowired
	SearchRepository searchRepository;
	
	public List<WriterDto> getSearchWriter(SearchDto searchDto) {
		List<WriterDto> list = searchRepository.getSearchWriter(searchDto);
	
		return list;
	}
	
	public List<ArticleDto> getSearchCont(SearchDto searchDto) {
		List<ArticleDto> list = searchRepository.getSearchCont(searchDto);
		return list;
	}
	
	
}
