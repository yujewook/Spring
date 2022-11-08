package com.fastcampus.ch4.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.ch4.domain.BoardDto;
import com.fastcampus.ch4.domain.PageHandler;
import com.fastcampus.ch4.service.BoardService;


@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@PostMapping("/write")
	public String write(HttpSession session,BoardDto boardDto) {
		String writer=(String)session.getAttribute("id");
		boardDto.setWriter(writer);
		
		try {
			boardService.write(boardDto);
			
			return"redirect:/board/list";
		} catch (Exception e) {
			
			e.printStackTrace();
			return"board";
		}
		
	}
	
	@GetMapping("/write")
	public String write(Model m) {
		m.addAttribute("mode","new");
		return "board";// 읽기와 쓰기 
	}
	
	@PostMapping("/remove")
	public String remove(Integer bno, Integer page, Integer pageSize, Model m, HttpSession session) {
		String writer = (String)session.getAttribute("id");
		try {
			boardService.remove(bno, writer);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		m.addAttribute("page",page);
		m.addAttribute("pageSize",pageSize);
		
		
		return"redirect:/board/list";
	}
	
	@GetMapping("/read")
	public String read(Integer bno , Model m) {
		try {
			BoardDto boardDto = boardService.read(bno);
			//m.addaddAttribute("boardDto",boardDto); 아래와 동일 
			m.addAttribute(boardDto);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return "board";
	}
	
	
	@GetMapping("/list")
	public String list(Integer page, Integer pageSize, Model m ,HttpServletRequest request) {
		if(!loginCheck(request))
			return "redirect:/login/login?toURL="+request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동
		if(page==null) page=1;
		if(pageSize==null) pageSize=10;
		
		try {
			
			int totalCnt = boardService.getCount();
			PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);
			
			Map map = new HashMap();
			map.put("offset", (page-1)*pageSize);
			map.put("pageSize", pageSize);
			
			List<BoardDto> list = boardService.getPage(map);
			m.addAttribute("list",list);
			m.addAttribute("ph",pageHandler);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "boardList"; // 로그인을 한 상태이면, 게시판 화면으로 이동
	}

	private boolean loginCheck(HttpServletRequest request) {
		// 1. 세션을 얻어서
		HttpSession session = request.getSession();
		// 2. 세션에 id가 있는지 확인, 있으면 true를 반환
		return session.getAttribute("id")!=null;
	}
}