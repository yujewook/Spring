package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

public class MethodCall2 {
	public static void main(String[] args) throws Exception{
		//1. YoilTeller2MVC ��ü�� ����
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTeller2MVC");
		Object obj = clazz.newInstance();
		
		//2. main �޼��忡�� ������ ����´�
		Method main = clazz.getDeclaredMethod("main", int.class, int.class, int.class, Model.class);
		
		//3. ���� �������̽��� ��ü�� �����Ҽ� ���� ������ BindingAwareModelMap();�� ���� ��ü����
		Model model = new BindingAwareModelMap();
		System.out.println("[before] model="+model);
		
		//4.main �޼��� ȣ��
		// String viewName = obj.main(2021, 10, 1, model);
		String viewName = (String)main.invoke(obj, new Object[] { 2021, 10, 1, model }); //Reflaction API�� �̿��� ȣ��	
		System.out.println("viewName="+viewName);	
		
		// Model�� ������ ��� 
		System.out.println("[after] model="+model);
				
		// �ؽ�Ʈ ������ �̿��� rendering
		render(model, viewName);			
	} // main
	
	static void render(Model model, String viewName) throws IOException {
		String result = "";
		
		// 1. ���� ������ ���پ� �о �ϳ��� ���ڿ��� �����.
		Scanner sc = new Scanner(new File("src/main/webapp/WEB-INF/views/"+viewName+".jsp"), "utf-8");
		
		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();
		
		// 2. model�� map���� ��ȯ 
		Map map = model.asMap();
		
		// 3.key�� �ϳ��� �о template�� ${key}�� value�ٲ۴�.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();

			// 4. replace()�� key�� value ġȯ�Ѵ�.
			result = result.replace("${"+key+"}", ""+map.get(key));
		}
		
		// 5.������ ����� ����Ѵ�.
		System.out.println(result);
	}
}