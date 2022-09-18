package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
	public static void main(String[]args) throws Exception {
		// 1. YoilTeller 객체를만든다. 예외처리를 해줘야한다.
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTeller");
		Object obj = clazz.newInstance();
		
		//2. YOILTELLER의 정보를 모두 배열에저장.
		Method[] methodArr = clazz.getDeclaredMethods();
		
		//
		for(Method m : methodArr) {
			String name = m.getName();									//메서드이름
			Parameter[] paramArr = m.getParameters();					//메서드 매개변수 목록
			//Class[] paramTypeArr = m.getParameterTypes();
			Class returnType = m.getReturnType(); 						//반환타입 
			
			StringJoiner paramList = new StringJoiner(", ", "(", ")");	//매개변수 
			for(Parameter param : paramArr) {
				String paramName = param.getName();
				Class  paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
		
	}

}
