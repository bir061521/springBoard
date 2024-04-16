package com.fastcampus.ch2.dao;

import com.fastcampus.ch2.dto.CommentDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class CommentDaoImplTest {

    @Autowired
    CommentDao commentDao;
    @Test
    public void now() {
        CommentDto commentDto = new CommentDto();

        commentDto.setRegDate(LocalDateTime.now());

       assertNotNull(commentDto.getRegDate());
    }

    @Test
    public void deleteAll() throws Exception {
        CommentDto commentDto  = new CommentDto();
        int result = commentDto.getBno(1037);
        System.out.println(commentDto);
        commentDao.deleteAll(result);
        assertTrue(commentDao.count(1037) == 0);

    }

    @Test
    public void count() throws Exception {
        CommentDto commentDto =  new CommentDto();
//        commentDto.setCno(16);
        commentDto.setBno(1037);
        commentDto.setId("asdf");
//        commentDto.setParent_cno(16);
        commentDto.setContent("집에잘ㄹㄹ");
        commentDto.setRegDate(LocalDateTime.now());

        int result = commentDao.insert(commentDto);

    }

    @Test
    public void insert() throws Exception {
       try{
           CommentDto commentDto1 = new CommentDto();
           commentDto1.setBno(1037);
           commentDto1.setId("asdf");
           commentDto1.setContent("댓글");
           commentDto1.setRegDate(LocalDateTime.now());

           commentDao.insert(commentDto1);

           CommentDto commentDto = new CommentDto();
//           commentDto.setCno(17);
           commentDto.setBno(1037);
           commentDto.setId("asdf");
           commentDto.setParent_cno(18);
           commentDto.setContent("대댓글");
           commentDto.setRegDate(LocalDateTime.now());

           int result = commentDao.insert(commentDto);

           if(result == 1){
               System.out.println("testSuccess:"+commentDto.getCno());
           }
       }catch (Exception e){
           System.out.println("testFail");
           e.printStackTrace();
       }



    }

    @Test
    public void delete() throws Exception {
//        CommentDto commentDto = new CommentDto();
//        commentDto.setCno(25);
//        commentDto.setBno(1037);
//        commentDto.setId("asdf");
////        commentDto.setParent_cno();
//        commentDto.setContent("대댓글");
//        commentDao.insert(commentDto);
//        assertNotNull(commentDto);

        commentDao.delete(27,"asdf");
        commentDao.delete(23,"asdf");


    }

    @Test
    public void select() {
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void update() {
    }
}