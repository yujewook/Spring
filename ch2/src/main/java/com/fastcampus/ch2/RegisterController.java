package com.fastcampus.ch2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RegisterController {
	@InitBinder
	public void toDate(WebDataBinder binder) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df,false));
	}
	
	@RequestMapping(value="/register/add", method={RequestMethod.GET, RequestMethod.POST})
	//@GetMapping("/register/add")
	public String register() {
		
		
		return "RegisterForm";
	}
	//@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(User user, BindingResult result , Model m) throws Exception {
		System.out.println("result="+ result);
		//���� ����
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user,result); //BindingResult�� Errors�� �ڼ�
		
		//User��ü�� ������ ����� ������ ������ registerForm�� �̿��ؼ� ������ ��������Ѵ�
		if(result.hasErrors()) {
			return "RegisterForm";
		}
		//1. ��ȿ�� �˻�
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode( "id���߸��Է��ϼ̽��ϴ�.","UTF-8");
//			m.addAttribute("msg",msg);
//			return "forward:/register/add";
			// return "redirect:/register/add?msg"+msg; m.addAttribute("msg",msg);�̰��� ���ָ� ������ ���ָ�ȴ�
//		}
		return "registerinfo";
	}
	
	private boolean isValid(User user) {
		
		return true;
	}
	
	
}
