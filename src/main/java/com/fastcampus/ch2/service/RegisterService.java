package com.fastcampus.ch2.service;

import com.fastcampus.ch2.dao.BoardDao;
import com.fastcampus.ch2.dao.UserDao;
import com.fastcampus.ch2.dto.UserDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface RegisterService {






    String insertUser(UserDto userDto)throws Exception;
}
