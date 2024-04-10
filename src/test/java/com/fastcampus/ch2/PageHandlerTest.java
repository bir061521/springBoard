package com.fastcampus.ch2;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class PageHandlerTest {

    @Test
    public void test() {
        //1 2 3 4 5 6 7 8 9 10
        //curPage = 5;
        //naviStart = 1;
        //naviEnd = 10;
        //naviSize=10;
        Page ph = new Page(1000, 5, 10);
        System.out.println("ph.getNaviStart = " + ph.getNaviStart());
        System.out.println("ph.naviEnd=" + ph.getNaviEnd());
        System.out.println(ph);


    }


    @Test
    public void test2() {
        Page ph = new Page(1029,10,21);
        System.out.println(ph);
        System.out.println(ph.getNAV_SIZE());
        System.out.println(ph.getPage());



    }

    @Test
    public void test3(){
        for(int i = 1; i<= 32; i++ ){
            System.out.printf("%d %d %n", i, ((i-1)*10));


        }
    }

}
//    @Test
//    public void test2(){
//        //1 2 3 4 5
//        //curPage = 5;
//        //naviStart = 1;
//        //naviEnd = 5;
//        Page ph = new Page(250, 2, 10);
//        System.out.println(2/10*10+1);
//        System.out.println();
//        System.out.println("ph=" + ph);
//        assertTrue(ph.getNaviStart() == 3);
//        assertTrue(ph.getNaviEnd()==25);
//
//
//
//    }

//}