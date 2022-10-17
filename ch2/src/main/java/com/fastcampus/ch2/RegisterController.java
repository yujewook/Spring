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
		//수동 검증
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user,result); //BindingResult는 Errors의 자손
		
		//User객체를 검증한 결과를 에러가 있으면 registerForm을 이용해서 에러를 보여줘야한다
		if(result.hasErrors()) {
			return "RegisterForm";
		}
		//1. 유효성 검사
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode( "id를잘못입력하셨습니다.","UTF-8");
//			m.addAttribute("msg",msg);
//			return "forward:/register/add";
			// return "redirect:/register/add?msg"+msg; m.addAttribute("msg",msg);이것을 써주면 위에만 써주면된다
//		}
		return "registerinfo";
	}
	
	private boolean isValid(User user) {
		
		return true;
	}
	
	
}
