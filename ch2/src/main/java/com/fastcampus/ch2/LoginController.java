package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//1. 세션을 종료
		session.invalidate();
		//2. 이동을 홈으로
		return "redirect:/";
	}

	@PostMapping("/login")
	public String login(String id , String pwd, boolean rememberId, String toURL,
			HttpServletResponse reponse, HttpServletRequest request) throws Exception {
	 
		// 1. id와 pwd 확인
		if(! loginCheck(id,pwd)) {
			String msg = URLEncoder.encode("id또는 pwd가 일치하지 않습니다.","utf-8");
			
		//2-1. 일치하지 않은면,loginForm으로 이동
			return "redirect:/login/login?msg="+msg; //redicrect는 get으로 가게 된다.
		}
		// 2-2. id와 pwd 일치하면 홈으로
		//세션객체를 얻어오기
		HttpSession session = request.getSession(); 
		// 로그인 상태유지를 위해 세션객체에 id를 저장
		session.setAttribute("id",id);
		
		if(rememberId) {
			//1. 쿠키생성
			Cookie cookie = new Cookie("id",id);
			//2. 응답에 저장
			reponse.addCookie(cookie);
		} else {
			//쿠키 삭제
			Cookie cookie = new Cookie("id",id);
			cookie.setMaxAge(0);
			reponse.addCookie(cookie);
		}
		// 3. 홈으로이동
		// url값이 없으면 홈으로 
		toURL= toURL == null || toURL.equals("")? "/" : toURL ;
		
		return "redirect:"+toURL;
		
	}

	private boolean loginCheck(String id, String pwd) {
		
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}
