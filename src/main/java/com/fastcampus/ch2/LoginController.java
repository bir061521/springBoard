package com.fastcampus.ch2;

import com.fastcampus.ch2.dao.UserDao;
import com.fastcampus.ch2.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

@Controller

public class LoginController {
    @RequestMapping(value="/loginform", method= RequestMethod.GET)
    public String loginForm(){
        return "LoginForm";
    }

   @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(value="/login" ,method = RequestMethod.POST)
    public String login(String id, String pwd, String redirectURL, boolean remember, HttpServletRequest request, HttpServletResponse response)throws Exception{
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setPwd(pwd);
        if(loginCheck(userDto) == null){
            String msg = URLEncoder.encode("id또는 pwd가 일치하지 않습니다", "utf-8");
           return "redirect:/loginform?msg=" + msg;

        }

        //세션이 일치한다면

        HttpSession session = request.getSession();
        session.setAttribute("id",id);

        if(remember) {
            Cookie cookie = new Cookie("id",id);
            cookie.setMaxAge(60);
            response.addCookie(cookie);

        }else {
            Cookie cookie = new Cookie("id","");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        redirectURL = redirectURL==null||redirectURL.equals(("")) ? "/" : redirectURL;

        return "redirect:"+redirectURL;


    }


    @Autowired
    UserDao userDao;
    private UserDto loginCheck(UserDto userDto){
        return userDao.selectUser(userDto.getId());

    }
}
