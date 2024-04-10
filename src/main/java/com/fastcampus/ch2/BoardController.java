package com.fastcampus.ch2;

import com.fastcampus.ch2.dto.BoardDto;
import com.fastcampus.ch2.service.BoardService;
import com.fastcampus.ch2.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

//    @Autowired
//    PageHandler pageHandler;

    @RequestMapping(value = "/boardList2", method = RequestMethod.GET)
    public String BoardList(Integer page, HttpServletRequest request, HttpServletResponse response, BoardDto boardDto, Model m) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(); // 기존 세션 가져오기, 없으면 null 반환

        String redirectURL = req.getServletPath();


        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        boolean isAuthenticated = false;


        if (session.getAttribute("id") != null && redirectURL != null && !redirectURL.isEmpty()) {

            int totalCnt = boardService.getCount();

            page =  page == null?1:page;
            Page ph = new Page(totalCnt, 10, page);

            Map map = new HashMap<>();

            map.put("offset",((page-1)*10));
            map.put("pageSize",10);

            List<BoardDto> list = boardService.getPage(map);

            m.addAttribute("list", list);
            m.addAttribute("ph",ph);






        } else {
            String msg = URLEncoder.encode("로그인을 먼저 해주세요", "utf-8");
            return "redirect:/?msg=" + msg;

        }

        return "BoardList2";
    }



    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String read(Integer bno, Model m) throws Exception {
        try {
            BoardDto boardDto = boardService.read(bno);
            m.addAttribute("boardDto",boardDto);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/boardList2";
        }

        return "board";


    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(Integer bno,Model m,HttpSession session,BoardDto boardDto)throws Exception{
        String writer = (String)session.getAttribute("id");
        try{
            boardService.remove(bno,writer);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        m.addAttribute("boardDto",boardDto);
        return "redirect:/boardList2";
    }


    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write(Model m){
        m.addAttribute("mode","new");
        return "board";
    }



    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String write(Integer bno, Model m, HttpSession session,BoardDto boardDto)throws Exception{
        String writer = (String)session.getAttribute("id");
        boardDto.setWriter(writer);
        try{
           int rowCnt =  boardService.write(boardDto);
           if(rowCnt != 1)throw new Exception("Write failed");
           m.addAttribute("msg","WRT_OK");


        }catch (Exception e){
            e.printStackTrace();
            m.addAttribute("boardDto",boardDto);
            m.addAttribute("mode","new");
            m.addAttribute("msg","WRT_ERR");
            return "board";


        }
//        m.addAttribute("boardDto",boardDto);
        return "redirect:/boardList2";

    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modify(RedirectAttributes redirectAttributes,Model m, HttpSession session, BoardDto boardDto)throws Exception{
        String writer = (String) session.getAttribute("id");
        boardDto.setWriter(writer);
        try{
           int rowCnt =boardService.modify(boardDto);
            if(rowCnt != 1)throw new Exception("Modify failed");
           redirectAttributes.addFlashAttribute("msg","WRT_OK");
            return "redirect:/boardList2";

        }catch (Exception e){
            e.printStackTrace();
            m.addAttribute("boardDto",boardDto);
            m.addAttribute("msg","MDD_ERR");
            return "board";


        }

    }



}