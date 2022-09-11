package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//년월일을 입력하면 어떤 요일인지 알려주는 프로그램 
//http://localhost:8080/ch2/getyoilMVC?year=2021&month=10&day=1
public class YoilTeller2MVC {
	@RequestMapping("/getyoilMVC")
	//public void main(HttpServletRequest request , HttpServletResponse response) throws IOException {
	// 원래는 void 로 HttpServletRequest request 대신 입력 받을 것을 직접받고 view이름 반환하기 때문에 ->String 으로 바꿔준다
	public String main(int year , int month, int day , Model model) throws IOException {
		//유효성 검사	
		if(!isValid(year,month,day))
			return "yoilError";
		
		//요일 계산하는 것
		char yoil = getYoil(year, month, day);
	
			//계산한 결과를 모델에 저장
			model.addAttribute("year",year);
			model.addAttribute("month",month);
			model.addAttribute("year", day);
			model.addAttribute("yoil", yoil);
			
			
		return "yoil";// web-inf안에views안에yoil.jsp를 사용하게 만든것
	
	}

	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1 ,day);
		
		int dayOfweek = cal.get(Calendar.DAY_OF_WEEK); //요일이 숫자로 나온다 1:일요일 , 2:월요일
		
		return " 일월화수목금토".charAt(dayOfweek); //그걸 다시 문자로;
	}

	
}
