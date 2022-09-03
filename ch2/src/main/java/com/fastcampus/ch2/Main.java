package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[]args) throws Exception {
//Hello hello = new Hello(); 는 private 이라 실행이 안된다 하지만
// hello.main(); 
	
		//reflection API를 사용 클래스 정보를 얻고 다룰 수 있다
		//java.lang.reflect패키지를 제공
		//Hello클래스의 Class 객체를(클래스 정보를 담고 있는 객체)를 얻어온다
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
			Hello hello = (Hello) helloClass.newInstance(); // Class가 가진 정보로 객체 생성
			Method main = helloClass.getDeclaredMethod("main");
			main.setAccessible(true);//private인 main() 호출가능하게 한다.
			
			main.invoke(hello);
	}
}
