package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RegisterController {

	@RequestMapping(value="/register/add", method={RequestMethod.GET, RequestMethod.POST})
	//@GetMapping("/register/add")
	public String register() {
		
		
		return "RegisterForm";
	}
	//@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(User user, Model m) throws Exception {
		if(!isValid(user)) {
			String msg = URLEncoder.encode( "id를잘못입력하셨습니다.","UTF-8");
			m.addAttribute("msg",msg);
			return "forward:/register/add";
			// return "redirect:/register/add?msg"+msg; m.addAttribute("msg",msg);이것을 써주면 위에만 써주면된다
		}
		return "registerinfo";
	}
	
	private boolean isValid(User user) {
		
		return false;
	}
	
	
}
