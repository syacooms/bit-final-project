package com.bit.paperhouse.dao;

import com.bit.paperhouse.dto.QnaDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QnaRepository {

    List<QnaDto>  qnaList();

    void writeQnaAf(QnaDto dto);
}
