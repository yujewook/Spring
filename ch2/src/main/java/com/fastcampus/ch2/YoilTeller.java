package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//년월일을 입력하면 어떤 요일인지 알려주는 프로그램 
public class YoilTeller {
	@RequestMapping("/getyoil")
	public void main(HttpServletRequest request , HttpServletResponse response) throws IOException {
		// 1. 입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		//2. 입력값 숫자화 해주는 변수
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		//3. 직업
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy,mm-1,dd);
		
		int dayOfweek = cal.get(Calendar.DAY_OF_WEEK); //요일이 숫자로 나온다 1:일요일 , 2:월요일
		char yoil =" 일월화수목금토".charAt(dayOfweek); //그걸 다시 문자로
		
		//4. 출력
		response.setContentType("text/7html"); //text로 보낸다는것을 알려주고ㅓ
		response.setCharacterEncoding("UTF-8");// 인코딩해준다.
		PrintWriter out = response.getWriter(); //response객체에서 브라우저로 출력 스트림을 얻는다.
		out.println(year+"년"+month+"월"+day+"일");
		out.println(yoil+"요일입니다.");
		
	 
		
		
	}
}
