package com.fastcampus.ch2;

import com.fastcampus.ch2.dao.UserDao;
import com.fastcampus.ch2.dto.UserDto;
import com.fastcampus.ch2.service.RegisterService;


import com.fastcampus.ch2.service.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @RequestMapping("/register/add")
    public String register(){
        System.out.println("진입");
        return "registerForm";
    }



    @RequestMapping(value="/register/save" ,method= RequestMethod.POST)
    public String registerPOST(UserDto userDto, Model m)throws Exception{

        String msg = registerService.insertUser(userDto);
        if(!msg.isEmpty()){
            m.addAttribute("msg",msg);
            return "redirect:/register/add";
        }
        return "redirect:/loginform";


    }



}
