package com.bit.paperhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.paperhouse.dao.MyPageRepository;
import com.bit.paperhouse.dto.WriterDto;

@Service
public class MypageService {

	@Autowired
	MyPageRepository dao;
	
	public List<WriterDto> getWriterNames(int userSeq) {
		List<WriterDto> list = dao.getWriterNames(userSeq);
		return list;
	}

	public int selectStatus(WriterDto dto) {
		int status = dao.selectStatus(dto);
		return status;
	}
	
	public void updateEndSub(int userSeq , String endDate) {
		dao.updateEndSub(userSeq,endDate);
	}

	
	
	

}
