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
		//1. ������ ����
		session.invalidate();
		//2. �̵��� Ȩ����
		return "redirect:/";
	}

	@PostMapping("/login")
	public String login(String id , String pwd, boolean rememberId, String toURL,
			HttpServletResponse reponse, HttpServletRequest request) throws Exception {
	 
		// 1. id�� pwd Ȯ��
		if(! loginCheck(id,pwd)) {
			String msg = URLEncoder.encode("id�Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.","utf-8");
			
		//2-1. ��ġ���� ������,loginForm���� �̵�
			return "redirect:/login/login?msg="+msg; //redicrect�� get���� ���� �ȴ�.
		}
		// 2-2. id�� pwd ��ġ�ϸ� Ȩ����
		//���ǰ�ü�� ������
		HttpSession session = request.getSession(); 
		// �α��� ���������� ���� ���ǰ�ü�� id�� ����
		session.setAttribute("id",id);
		
		if(rememberId) {
			//1. ��Ű����
			Cookie cookie = new Cookie("id",id);
			//2. ���信 ����
			reponse.addCookie(cookie);
		} else {
			//��Ű ����
			Cookie cookie = new Cookie("id",id);
			cookie.setMaxAge(0);
			reponse.addCookie(cookie);
		}
		// 3. Ȩ�����̵�
		// url���� ������ Ȩ���� 
		toURL= toURL == null || toURL.equals("")? "/" : toURL ;
		
		return "redirect:"+toURL;
		
	}

	private boolean loginCheck(String id, String pwd) {
		
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}
