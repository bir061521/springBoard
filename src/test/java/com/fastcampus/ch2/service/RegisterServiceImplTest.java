package com.fastcampus.ch2.service;

import com.fastcampus.ch2.dao.UserDao;
import com.fastcampus.ch2.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class RegisterServiceImplTest {

    @Autowired
    UserDao userDao;

    @Autowired
    RegisterService registerService;
    @Test
    public void insertUser() {
        UserDto userDto = new UserDto();
        UserDto userDto1 = new UserDto();

        userDto.setId("asdf");
        userDto.setPwd("1234");
        userDto.setName("min");
        userDto.setBirth("1999-06-15");
        userDto.setSns("facebook");
        userDto.setEmail("bir0615@naver.com");


//        userDto1.setId("bjsl;rjg");
//        userDto1.setPwd("5678");
//        userDto1.setName("jeong");
//        userDto1.setBirth("1999-06-15");
//        userDto1.setSns("kakaotalk");
//        userDto1.setEmail("bir0615@naver.com");
//
        try{
            userDao.insertUser(userDto);

        }catch(DuplicateKeyException e){
            System.out.println(userDto.toString());
            System.out.println("중복된 아이디를 잡아냈따.");

        }

    }
}