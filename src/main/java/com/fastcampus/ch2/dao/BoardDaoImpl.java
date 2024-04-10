package com.fastcampus.ch2.dao;

import com.fastcampus.ch2.dto.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardDaoImpl implements BoardDao{

    @Autowired
    private SqlSession session;//쓰래드 세이프
    private static String namespace = "com.fastcampus.ch2.dao.BoardMapper.";

    public String getServerTime()throws Exception{
        return session.selectOne(namespace + "now");
    }

    @Override
    public int deleteAll() throws Exception {
       return session.delete(namespace + "deleteAll");
    }

    public int count()throws Exception{
        return session.selectOne(namespace + "count");
    }

    @Override
    public int insert(BoardDto dto) throws Exception {
        return session.insert(namespace+"insert",dto);
    }

    @Override
    public BoardDto select(Integer bno) throws Exception {
        return session.selectOne(namespace+"select", bno);
    }


    @Override
    public int update(BoardDto dto) throws Exception {
        return session.update(namespace +"update", dto);
    }


    @Override
    public int increaseViewCnt(Integer bno) throws Exception {
        return session.update(namespace+"increaseViewCnt", bno);
    }

    @Override
    public List<BoardDto> selectAll() throws Exception {
        return  session.selectList(namespace +"selectAll");
    }

    @Override
    public List<BoardDto> selectPage(Map map) throws Exception {
        return session.selectList(namespace+"selectPage", map);
    }



    @Override
    public int delete(Integer bno,String writer) throws Exception {
        return session.delete(namespace+"delete", bno);
    }





}
