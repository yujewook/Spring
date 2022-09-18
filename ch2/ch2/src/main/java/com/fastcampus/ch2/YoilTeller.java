package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//������� �Է��ϸ� � �������� �˷��ִ� ���α׷� 
public class YoilTeller {
	@RequestMapping("/getyoil")
	public void main(HttpServletRequest request , HttpServletResponse response) throws IOException {
		// 1. �Է�
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		//2. �Է°� ����ȭ ���ִ� ����
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		//3. ����
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy,mm-1,dd);
		
		int dayOfweek = cal.get(Calendar.DAY_OF_WEEK); //������ ���ڷ� ���´� 1:�Ͽ��� , 2:������
		char yoil =" �Ͽ�ȭ�������".charAt(dayOfweek); //�װ� �ٽ� ���ڷ�
		
		//4. ���
		response.setContentType("text/7html"); //text�� �����ٴ°��� �˷��ְ��
		response.setCharacterEncoding("UTF-8");// ���ڵ����ش�.
		PrintWriter out = response.getWriter(); //response��ü���� �������� ��� ��Ʈ���� ��´�.
		out.println(year+"��"+month+"��"+day+"��");
		out.println(yoil+"�����Դϴ�.");
		
	 
		
		
	}
}
