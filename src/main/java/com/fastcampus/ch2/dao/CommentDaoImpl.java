package com.fastcampus.ch2.dao;

import com.fastcampus.ch2.dto.CommentDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SqlSession session;

    private static String namespace = "com.fastcampus.ch2.dao.CommentMapper.";


    @Override
    public String now()throws Exception{
        return session.selectOne(namespace +"now");

    }



    @Override
    public int deleteAll(Integer bno)throws Exception{
        return session.delete(namespace + "deleteAll");
    }
    @Override
    public int count(Integer bno)throws Exception{
        return session.selectOne(namespace + "count");
    }

    @Override
    public int insert(CommentDto commentDto)throws Exception{
        return session.insert(namespace + "insert", commentDto);
    }

    @Override
    public int delete(Integer cno, String id) throws Exception {
        Map<String,Object> params= new HashMap<>();
        params.put("cno",cno);
        params.put("id",id);
        return session.delete(namespace + "delete", params);
    }



    @Override
    public CommentDto select(Integer cno)throws Exception{
        return session.selectOne(namespace + "select");
    }


  @Override
  public List<CommentDto> selectAll(Integer bno,CommentDto commentDto)throws Exception{
        return session.selectList(namespace + "selectAll",commentDto);
  }


  @Override
  public int update(CommentDto commentDto)throws Exception{
        return session.update(namespace + "update",commentDto);
  }

}
