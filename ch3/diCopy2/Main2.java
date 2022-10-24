package com.fastcampus.ch3.diCopy2;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class Car{}
class SportCar extends Car{}
class TruckCar extends Car{}
class AppContext{
	Map map ; // 객체 저장소
	
	AppContext(){
		map = new HashMap();
		map.put("car", new SportCar());
	}
	Object getBean(String key) {
		return map.get(key);
	}
	
}

public class Main2 {
	public static void main(String[]args) throws Exception{
		AppContext ac = new AppContext();
		
		//Car car = getCar();
		Car car = (Car)ac.getBean("car");
	
		System.out.println("car="+car);
	}
	static Car getCar() throws Exception {
		Properties p = new Properties();
		p.load(new FileReader("config.txt"));
		
		
		Class clazz = Class.forName(p.getProperty("car"));
		
		return (Car)clazz.newInstance();
	}
	static Object getBean(String key) throws Exception {
		Properties p = new Properties();
		p.load(new FileReader("config.txt"));
		
		
		Class clazz = Class.forName(p.getProperty("car"));
		
		return clazz.newInstance();
	}
	
}
