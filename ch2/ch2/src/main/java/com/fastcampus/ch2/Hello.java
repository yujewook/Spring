package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	int iv = 10;
	static int cv = 20;
	
	@RequestMapping("/hello")
	private void main() {		// �ν��Ͻ� �޼ҵ� iv,cv ���� �����ϴ�. 
		System.out.println("hello");
	}

	
	public static void main2() {
		System.out.println(cv); //ok
		//System.out.println(iv);//����
	}
	
}
