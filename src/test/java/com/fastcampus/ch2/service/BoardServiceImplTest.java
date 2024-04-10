package com.fastcampus.ch2.service;

import com.fastcampus.ch2.dao.BoardDao;
import com.fastcampus.ch2.dao.UserDao;
import com.fastcampus.ch2.dto.BoardDto;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardServiceImplTest {

    @Autowired
    BoardDao boardDao;

    @Autowired
    BoardServiceImpl boardService;

    @Test
    public void getCount()throws Exception{
        assertTrue(boardDao.count()==10);
    }

    @Test
    public void getPage()throws Exception{
        Map map = new HashMap<>();

        map.put("offset",2);
        map.put("pageSize",10);

        List<BoardDto>list = boardService.getPage(map);

        assertTrue(list != null);

        Iterator it = list.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }



    }



//
//
//
//    @Autowired
//    BoardDao boardDao;
//
//    @Autowired
//    BoardServiceImpl boardService;
//
//    @DisplayName("selectAllTest")
//    @Test
//    public void selectAll() throws Exception {
//        System.out.println(boardDao.selectAll().toString());
//    }


//
//    @DisplayName("readTest")
//    @Test
//    public void read()throws Exception{
//        Integer bno = 1;
//        BoardDto boardDtoBefore = boardDao.select(bno); // 조회 전 조회 수
//        System.out.println(boardDtoBefore);
//        System.out.println(boardService.read(bno));
//        BoardDto boardDtoAfter = boardDao.select(bno); // 조회 후 조회 수
//
//        assertEquals(boardDtoBefore.getView_cnt() + 1, boardDtoAfter.getView_cnt()); // 조회 수 검증
//    }

//    @DisplayName("deleteTest")
//    @Test
//    public void delete()throws Exception{
//
//    }
//
//    @DisplayName("writeTest")
//    @Test
//    public void write()throws Exception{
//        BoardDto boardDto = new BoardDto();
//        boardDto.setBno();
//        boardDto.setWriter();
//        boardDto.setContent();
//        boardDto.setView_cnt();
//        boardDto.setReg_date();
//        boardDto.setComment_cnt();
//    }
}