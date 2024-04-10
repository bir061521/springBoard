package com.fastcampus.ch2.dao;

import com.fastcampus.ch2.dto.BoardDto;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.time.LocalTime.now;
import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDaoImplTest {

    @Autowired
    BoardDao boardDao;


    @DisplayName("insertTest")
    @Test
    public void insert() throws Exception {
//        BoardDto boardDto = new BoardDto();
//        boardDto.setTitle("title");
//        boardDto.setContent("content");
//        boardDto.setWriter("writer");
//
//        int result = boardDao.insert(boardDto);
//        assertEquals(1,result);

        try{
        for (int i = 1; i <=300; i++) {
            try {
                BoardDto boardDto = new BoardDto();
                boardDto.setBno(i);
                boardDto.setTitle("title" + i);
                boardDto.setContent("content" + i);
                boardDto.setWriter("writer" + i);
                boardDto.setView_cnt(0);
                boardDto.setReg_date(LocalDateTime.now());

                int result = boardDao.insert(boardDto);

                if(result != 1){
                    System.err.println("Insert failed for record: " + i);
                }
            }catch (Exception e){
                System.err.println("Exception during insert for record: " + i);
                e.printStackTrace();
            }
        }
        } catch (Exception e) {
            throw new RuntimeException("UnexpectedErr",e);

        }

    }

    @DisplayName("selectTest")
    @Test
    public void select() throws Exception {
        // boardDao가 주입이 잘 되었는지 확인
        assertTrue(boardDao != null);


        BoardDto boardDto = boardDao.select(726);
        System.out.println("boardDto = " + boardDto);

        assertTrue(boardDto.getBno().equals(726));
    }


//    @DisplayName("updateTest")
//    @Test
//    public void update()throws Exception{
//        BoardDto boardDto = new BoardDto();
//
//        boardDto.setTitle("before title");
//        boardDto.setContent("before content");
//        boardDto.setWriter(" before writer");
//        int insertID = boardDao.insert(boardDto);
//
//        BoardDto updateDto = new BoardDto();
//        updateDto.setBno(insertID);
//        updateDto.setTitle("after title");
//        updateDto.setContent("after content");
//        updateDto.setWriter("after writer");
//        boardDao.update(updateDto);
//
//
//       updateDto = boardDao.select(insertID);
//       assertEquals("after title", updateDto.getTitle());
//       assertEquals("after content",updateDto.getContent());
//       assertEquals("after writer",updateDto.getWriter());
//    }

    @DisplayName("countTest")
    @Test
    public void count()throws Exception{
       BoardDto boardDto = new BoardDto();

        System.out.println( boardDao.count());


    }

    @DisplayName("deleteTest")
    @Test
    public void delete()throws Exception{
        BoardDto boardDto = new BoardDto();
        boardDto.setBno(1);
        boardDto.setTitle("title");
        boardDto.setContent("content");
        boardDto.setWriter("writer");
        int result = boardDao.insert(boardDto);
        assertEquals(1,result);

        System.out.println(boardDto.getBno());
        System.out.println(boardDto.toString());

        System.out.println(boardDao.count());
        boardDao.delete(370, boardDto.getWriter());
        System.out.println(boardDao.count());

    }

    @DisplayName("deleteAllTest")
    @Test
    public void deleteAll()throws Exception{
        // deleteAll 실행 전 게시물 수 확인 (선택적)
        int beforeCount = boardDao.count();
        System.out.println("Before deleteAll: " + beforeCount);

        // 모든 게시물 삭제
        boardDao.deleteAll();

        // deleteAll 실행 후 게시물 수 확인
        int afterCount = boardDao.count();
        System.out.println("After deleteAll: " + afterCount);

        // 기대 결과 검증 - 게시물 수가 0이어야 함
        assertTrue(afterCount == 0);
    }


    @DisplayName("selectAllTest")
    @Test
    public void selectAll()throws Exception{
        System.out.println(boardDao.count());
        boardDao.selectAll();
//        System.out.println(boardDao.selectAll().iterator() );

    }
    @Test
    public void increaseViewCntTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count()==0);

        BoardDto boardDto = new BoardDto();
        boardDto.setBno(1);
        boardDto.setTitle("title");
        boardDto.setContent("content");
        boardDto.setWriter("writer");
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.count()==1);

        Integer bno = boardDao.selectAll().get(0).getBno();
        assertTrue(boardDao.increaseViewCnt(bno)==1);

        boardDto = boardDao.select(bno);
        assertTrue(boardDto!=null);
        assertTrue(boardDto.getView_cnt() == 1);

        assertTrue(boardDao.increaseViewCnt(bno)==1);
        boardDto = boardDao.select(bno);
        assertTrue(boardDto!=null);
        assertTrue(boardDto.getView_cnt() == 2);
    }


    @DisplayName("selectPage")
    @Test
    public void selectPage()throws Exception{
        boardDao.deleteAll();

        for(int i = 1; i <= 10; i++){
            BoardDto boardDto = new BoardDto();
            boardDto.setBno(i);
            boardDto.setTitle("title" + i);
            boardDto.setContent("content");
            boardDto.setWriter("writer");

            boardDao.insert(boardDto);
        }
        Map map  = new HashMap<>();
        map.put("offset",0);
        map.put("pageSize",3);

        List<BoardDto> list = boardDao.selectPage(map);
        assertTrue(Objects.equals(list.get(0).getTitle(), "title10"));
        assertTrue(Objects.equals(list.get(1).getTitle(), "title9"));
        assertTrue(Objects.equals(list.get(2).getTitle(), "title8"));

    }


}