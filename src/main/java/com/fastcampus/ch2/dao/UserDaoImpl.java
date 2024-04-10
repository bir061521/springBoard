package com.fastcampus.ch2.dao;

import com.fastcampus.ch2.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSession session;

    private static String namespace = "com.fastcampus.ch2.dao.UserMapper.";
    @Override
    public int deleteUser(String id) {
        return session.delete(namespace+"deleteUser", id);
    }

    @Override
    public UserDto selectUser(String id) {
        return session.selectOne(namespace + "selectUser", id);
    }

    @Override
    public int insertUser(UserDto user) {
        return session.insert(namespace+"insertUser", user);
    }

    @Override
    public int updateUser(UserDto user) {
        return session.update(namespace+"updateUser", user);
    }
}
