package com.fastcampus.ch3;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component class Engine{}
@Component class Door{}
@Component //자동으로 bean객체로 상
class Car{
	String color;
	int oil;
	@Autowired Engine engine;
	@Autowired Door[] doors; 

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getOil() {
		return oil;
	}
	public void setOil(int oil) {
		this.oil = oil;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Door[] getDoors() {
		return doors;
	}
	public void setDoors(Door[] doors) {
		this.doors = doors;
	}
	@Override
	public String toString() {
		return "Car [color=" + color + ", oil=" + oil + ", engine=" + engine + ", doors=" + Arrays.toString(doors)
				+ "]";
	}
}



public class SpringDiTest {
	public static void main(String[]args) {
		ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
		Car car = (Car) ac.getBean("car");
		Engine engine = (Engine) ac.getBean("engine");
		Door door = (Door) ac.getBean("door");
		
//		car.setColor("red");
//		car.setOil(45);
//		car.setEngine(engine);
//		car.setDoors(new Door[] {ac.getBean("door",Door.class),ac.getBean("door",Door.class)});
		System.out.println("car="+car);
		
	}
}
