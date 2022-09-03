package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	int iv = 10;
	static int cv = 20;
	
	@RequestMapping("/hello")
	private void main() {		// 인스턴스 메소드 iv,cv 전부 가능하다. 
		System.out.println("hello");
	}

	
	public static void main2() {
		System.out.println(cv); //ok
		//System.out.println(iv);//에러
	}
	
}
