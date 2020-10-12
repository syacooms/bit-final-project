package com.bit.paperhouse.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bit.paperhouse.dto.WriterDto;
import com.bit.paperhouse.service.MypageService;
import com.bit.paperhouse.util.UtilEx;


@Controller
public class MyPageController {

	@Autowired
	MypageService service;
	
	//mypage 메인
	@GetMapping("/mypage")
	public String mypage(Model model) {
		
		//session -> seq 대입..
		//DB NAME,DATE 조회
		List<WriterDto> getNamesAndDates = service.getWriterNames(new WriterDto(1, 0, null, null, null, null, null, 0, null, null));
		
		System.out.println("리스트:" + getNamesAndDates.toString());
		
		//남은 구독일 수 조회하는 함수
		HashMap<String, Integer> map = UtilEx.getSubscribes(getNamesAndDates);
		
		model.addAttribute("map" , map);
		
        return "mypage";
    }
	
	//내 정보 관리
	@GetMapping("/mypage/mypageInfo")
	public String mypageInfo() {
        return "mypageInfo";
    }
	
	//작가 신청하기
	@GetMapping("/writer/application")
	public String writerRegi() {
        return "writerApplication";
    }
	
	//공지사항
	@GetMapping("/notice")
	public String notice() {
        return "notice";
    }
	
	//1:1문의
	@GetMapping("/qna")
	public String qna() {
        return "qna";
    }
	
	//로그아웃
	@PostMapping("/user/logout")
	public String logout() {
        return "logout";
    }
}
