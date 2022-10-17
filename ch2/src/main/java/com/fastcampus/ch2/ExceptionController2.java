package com.fastcampus.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)// 500->400������ �ȴ�
class MyException extends RuntimeException {
	MyException(String msg){
		super(msg);
	}
	MyException(){this("");}
}

@Controller
public class ExceptionController2 {
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)// 200������ 500������ �ȴ�
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex",ex);
		return"error";
	}
	@ExceptionHandler(NullPointerException.class)
	public String catcher2(Exception ex,Model m) {
		m.addAttribute("ex",ex);
		return"error";
	}
	
	@RequestMapping("/ex3")
	public String main() throws Exception {
			throw new MyException("������ �߻��߽��ϴ�.");
	}
	@RequestMapping("/ex1")
	public String main2() throws Exception {
		throw new NullPointerException("������ �߻��߽��ϴ�.");
	}
}
