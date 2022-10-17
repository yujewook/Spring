package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		if(!loginCheck(request)) 
			return "redirect:/login/login?toURL="+request.getRequestURL(); //로그인을 안하면 로그인페이지로 이동
																		   //request.getRequestURL() GET방식으로 loginForm으로 가게만든다.
		return "boardList"; //로그인을 했으면 게시판으로 가게된다.
	}

	private boolean loginCheck(HttpServletRequest request) {
		// 1. 세션을 열어서 
		HttpSession session = request.getSession();
		// 2. 세션에 id가 있는지 확인 있으면 trues
//		if (session.getAttribute("id")!=null)
//			return true;
//		else
//			return false; //아래 한줄과 똑같은 의미이다. 
		return session.getAttribute("id")!=null ;
			
	}
}
