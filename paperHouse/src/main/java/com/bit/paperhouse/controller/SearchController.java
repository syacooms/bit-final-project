package com.bit.paperhouse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.paperhouse.dto.ArticleDto;
import com.bit.paperhouse.dto.SearchDto;
import com.bit.paperhouse.dto.WriterDto;
import com.bit.paperhouse.service.SearchService;

@Controller
public class SearchController {

	final int VIEW_TOTAL_PAGE = 6;
	
	@Autowired
	SearchService searchService;
	
	@RequestMapping(value = "/search")
	public String search() {
		System.out.println("SearchController search");
		return "/search";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getSearchWlist", method = RequestMethod.GET)
	public List<WriterDto> getSearchList(SearchDto searchDto) {
		if(searchDto.getSearchSort() == null || searchDto.getSort() == null) {
			searchDto.setSearchSort("WRITER_NAME");
			searchDto.setSort("ASC");
		}
		System.out.println("getSearchWlist");
		int np = searchDto.getNowPage();
		int start = np*VIEW_TOTAL_PAGE+1;
		int end = start+VIEW_TOTAL_PAGE-1;
		
		searchDto.setStart(start);
		searchDto.setEnd(end);
		
		List<WriterDto> list = searchService.getSearchWriter(searchDto);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getSearchClist",method = RequestMethod.GET)
	public Map<String, Object> getSearchCont(SearchDto searchDto){
		if(searchDto.getSearchSort()==null || searchDto.getSort() ==null) {
			searchDto.setSearchSort("VIEWCOUNT");
			searchDto.setSort("DESC");
		}
		System.out.println("getSearchClist");
		int np = searchDto.getNowPage();
		int start = np*VIEW_TOTAL_PAGE+1;
		int end = start+VIEW_TOTAL_PAGE-1;
		
		searchDto.setStart(start);
		searchDto.setEnd(end);
		Map<String, Object> map = searchService.getSearchCont(searchDto);
		
		return map;
	}
}
