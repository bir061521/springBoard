package com.fastcampus.ch2.dao;

import com.fastcampus.ch2.dto.UserDto;

public interface UserDao {
    int deleteUser(String id);
    UserDto selectUser(String id);

    int insertUser(UserDto user);

    int updateUser(UserDto user);
}
