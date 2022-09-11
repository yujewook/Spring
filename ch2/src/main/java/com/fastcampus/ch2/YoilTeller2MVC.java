package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//������� �Է��ϸ� � �������� �˷��ִ� ���α׷� 
//http://localhost:8080/ch2/getyoilMVC?year=2021&month=10&day=1
public class YoilTeller2MVC {
	@RequestMapping("/getyoilMVC")
	//public void main(HttpServletRequest request , HttpServletResponse response) throws IOException {
	// ������ void �� HttpServletRequest request ��� �Է� ���� ���� �����ް� view�̸� ��ȯ�ϱ� ������ ->String ���� �ٲ��ش�
	public String main(int year , int month, int day , Model model) throws IOException {
		//��ȿ�� �˻�	
		if(!isValid(year,month,day))
			return "yoilError";
		
		//���� ����ϴ� ��
		char yoil = getYoil(year, month, day);
	
			//����� ����� �𵨿� ����
			model.addAttribute("year",year);
			model.addAttribute("month",month);
			model.addAttribute("year", day);
			model.addAttribute("yoil", yoil);
			
			
		return "yoil";// web-inf�ȿ�views�ȿ�yoil.jsp�� ����ϰ� �����
	
	}

	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1 ,day);
		
		int dayOfweek = cal.get(Calendar.DAY_OF_WEEK); //������ ���ڷ� ���´� 1:�Ͽ��� , 2:������
		
		return " �Ͽ�ȭ�������".charAt(dayOfweek); //�װ� �ٽ� ���ڷ�;
	}

	
}
