package com.fastcampus.ch2.service;

import com.fastcampus.ch2.dao.UserDao;
import com.fastcampus.ch2.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    UserDao userDao;

    @Override
    public  String insertUser(UserDto userDto)throws Exception {

        try{
            userDao.insertUser(userDto);
        }catch (DuplicateKeyException e){
            return "중복된 아이디를 사용하여 등록할 수 업습니다.";
        }
        return "";
    }





}

