package com.fastcampus.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)// 500->400에러가 된다
class MyException extends RuntimeException {
	MyException(String msg){
		super(msg);
	}
	MyException(){this("");}
}

@Controller
public class ExceptionController2 {
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)// 200에러가 500에러가 된다
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
			throw new MyException("에러가 발생했습니다.");
	}
	@RequestMapping("/ex1")
	public String main2() throws Exception {
		throw new NullPointerException("에러가 발생했습니다.");
	}
}
