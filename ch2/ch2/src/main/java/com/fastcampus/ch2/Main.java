package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[]args) throws Exception {
//Hello hello = new Hello(); �� private �̶� ������ �ȵȴ� ������
// hello.main(); 
	
		//reflection API�� ��� Ŭ���� ������ ��� �ٷ� �� �ִ�
		//java.lang.reflect��Ű���� ����
		//HelloŬ������ Class ��ü��(Ŭ���� ������ ��� �ִ� ��ü)�� ���´�
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
			Hello hello = (Hello) helloClass.newInstance(); // Class�� ���� ������ ��ü ����
			Method main = helloClass.getDeclaredMethod("main");
			main.setAccessible(true);//private�� main() ȣ�Ⱑ���ϰ� �Ѵ�.
			
			main.invoke(hello);
	}
}
