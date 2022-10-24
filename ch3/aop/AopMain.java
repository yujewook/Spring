package com.fastcampus.ch3.aop;

import java.lang.reflect.Method;

public class AopMain {
	public static void main(String[]args) throws Exception {
		MyAdvice myAdvice = new MyAdvice();
		
		Class myClass = Class.forName("com.fastcampus.ch3.MyClass");
		Object obj = myClass.newInstance();
		
		for(Method m : myClass.getDeclaredMethods() ) {
			myAdvice.invoke(m, obj ,null);
		}
	}
}
class MyAdvice{
	void invoke(Method m , Object obj, Object... args ) throws Exception{
		System.out.println("[before]");
		m.invoke(obj, args);
		System.out.println("[after]");
	}
}


class MyClass{
	void aaa(){
		System.out.println("aaa()is called");
	}
	void aaa1(){
		System.out.println("aaa1()is called");
	}
	void aaa2(){
		System.out.println("aaa2()is called");
	}
	
}