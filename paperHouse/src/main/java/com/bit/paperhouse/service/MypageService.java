package com.bit.paperhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.paperhouse.dao.MyPageRepository;
import com.bit.paperhouse.dto.WriterDto;

@Service
public class MypageService implements MyPageRepository {

	@Autowired
	MyPageRepository dao;
	
	@Override
	public List<WriterDto> getWriterNames(WriterDto dto) {
		List<WriterDto> list = dao.getWriterNames(dto);
		return list;
	}

	@Override
	public int selectStatus(WriterDto dto) {
		int status = dao.selectStatus(dto);
		return status;
	}
	
	@Override
	public void updateEndSub(int userSeq , String endDate) {
		dao.updateEndSub(userSeq,endDate);
	}

	
	
	

}
