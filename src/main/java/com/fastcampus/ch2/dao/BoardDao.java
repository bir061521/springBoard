package com.fastcampus.ch2.dao;

import com.fastcampus.ch2.dto.BoardDto;

import java.util.List;
import java.util.Map;

public interface BoardDao {
    int deleteAll() throws Exception;
    int count() throws Exception;

    BoardDto select(Integer bno) throws Exception;
    int delete(Integer bno,String writer)throws Exception;
    int insert(BoardDto dto)throws Exception;
    int update(BoardDto dto)throws Exception;
    int increaseViewCnt(Integer bno)throws Exception;

    List<BoardDto> selectAll()throws Exception;
    List<BoardDto> selectPage(Map map)throws Exception;


}
