package com.ltns.rest_area.controller.user;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltns.rest_area.domain.user.UserDTO;
import com.ltns.rest_area.validator.user.UserValidation;

@RestController
public class UserRestController {
	

	@PostMapping("/auth/user/join")
	public void userJoin(@Valid UserDTO user, BindingResult bindingResult) {
				
		if(bindingResult.hasErrors()) {
			
		} else {
			System.out.println("디비 입력");
		}
		
		
	}
	
	@InitBinder
	public void intBinder(WebDataBinder webDataBinder) {
		webDataBinder.setValidator(new UserValidation());
	}
}
