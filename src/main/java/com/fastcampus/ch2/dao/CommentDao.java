package com.fastcampus.ch2.dao;

import com.fastcampus.ch2.dto.CommentDto;

import java.util.List;
import java.util.Map;

public interface CommentDao {
    String now() throws Exception;

    int deleteAll(Integer bno) throws Exception;

    int count(Integer bno) throws Exception;

    int insert(CommentDto commentDto) throws Exception;

    int  delete(Integer cno, String id) throws Exception;

    CommentDto select(Integer cno) throws Exception;

    List<CommentDto> selectAll(Integer bno) throws Exception;

    int update(CommentDto commentDto) throws Exception;
}
