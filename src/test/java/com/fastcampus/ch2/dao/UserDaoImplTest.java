package com.fastcampus.ch2.dao;

import com.fastcampus.ch2.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Objects;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UserDaoImplTest {

    @Autowired
    UserDao userDao;

    @Test
    public void deleteUser() {

        assertTrue(userDao != null);
        System.out.println("userDao=" + userDao);

        UserDto userDto = new UserDto();
        userDto.setId("asdf");
        userDto.setPwd("1234");
        userDto.setName("minjeong");
        userDto.setEmail("bir0615@naver.com");
        userDto.setBirth("1999-06-15");
        userDto.setSns("facebook");
        System.out.println(userDto.toString());

        assertTrue(userDto.getId() == "asdf");
        assertNotNull(userDao);
        System.out.println(userDao);
        String userId = "asdf";
        int result = userDao.deleteUser(userId);

        assertEquals(1, result);


    }

    @Test
    public void selectUser() {
        assertTrue(userDao != null);
        System.out.println("userDao=" + userDao);

        UserDto userDto = userDao.selectUser("asdf");
        System.out.println("userDto=" + userDto);


    }

    @Test
    public void insertUser() {
        UserDto userDto = new UserDto();
        userDto.setId("asdf");
        userDto.setPwd("1234");
        userDto.setName("minjeong");
        userDto.setEmail("bir0615@naver.com");
        userDto.setBirth("1999-06-15");
        userDto.setSns("facebook");

        int result = userDao.insertUser(userDto);
        assertEquals(1,result);
    }

    @Test
    public void updateUser() {
        UserDto userDto = new UserDto();
        userDto.setId("eeee");
        userDto.setPwd("1234");
        userDto.setName("minjeong");
        userDto.setEmail("bir0615@naver.com");
        userDto.setBirth("1999-06-15");
        userDto.setSns("facebook");



        System.out.println(userDto.toString());
        assertTrue(Objects.equals(userDto.getId(), "eeee"));
        assertNotNull(userDao);
        System.out.println(userDao);


        userDto.setPwd("5678");
        userDto.setName("midfsa");
        userDto.setEmail("dfads@naver.com");
        userDto.setBirth("1999-06-15");
        userDto.setSns("fadok");

        int result = userDao.updateUser(userDto);
        assertEquals(1, result);
        System.out.println(userDto.toString());

//        assertEquals(1, rowCnt);
//        userDto.setPwd("5678");
//        userDto.setName("mmin");
//        userDto.setEmail("df@naver.com");
//        userDto.setBirth("1999-07-27");
//        userDto.setSns("instagram");
//        rowCnt = userDao.updateUser(userDto);
//        assertEquals(1, rowCnt);

//        userDto.setPwd("5678");
//        userDto.setName("mm");
//        userDto.setEmail("bir0615@naver.com");
//        userDto.setBirth("1999-06-15");
//        userDto.setSns("facebook");
//        rowCnt = userDao.updateUser(userDto.get);
//        assertEquals(1, rowCnt);

    }
}