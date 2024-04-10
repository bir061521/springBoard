package com.fastcampus.ch2.service;

import com.fastcampus.ch2.dto.BoardDto;

import java.util.List;
import java.util.Map;

public interface BoardService {

     List<BoardDto> selectAll() throws Exception;


     public BoardDto read(Integer bno)throws Exception;

     public int remove(Integer bno,String writer)throws Exception;

     public int write(BoardDto boardDto)throws Exception;

     public int modify(BoardDto boardDto)throws Exception;

     public int getCount()throws Exception;
     List<BoardDto> getPage(Map map)throws Exception;
}
