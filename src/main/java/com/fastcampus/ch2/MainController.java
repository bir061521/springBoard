//package com.fastcampus.ch2;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.Arrays;
//
//@Controller
//public class MainController {
//
//    @Autowired
//    ApplicationContext ac;//<-상수(read-only), thread-safe
//
//    @RequestMapping("/")
//    public String main(){
//        //ac를 사용하고 싶을땐 어떻게?
//        System.out.println("ac=" + ac);
//        ApplicationContext rootAc = ac.getParent();
//        System.out.println("rootAc="+ rootAc);
//        System.out.println(Arrays.toString(ac.getBeanDefinitionNames()));
//
//        System.out.println("--main called");
//        return "Index";//WEB-INF/views/Index.jsp
//    }
//}
