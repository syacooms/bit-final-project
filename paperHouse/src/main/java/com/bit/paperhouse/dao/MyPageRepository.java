package com.bit.paperhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.bit.paperhouse.dto.WriterDto;

@Mapper
@Repository 
public interface MyPageRepository {
	
    public List<WriterDto> getWriterNames(WriterDto dto);
    public int selectStatus(WriterDto dto);
    public void updateEndSub(int userSeq , String endDate);
 
}
