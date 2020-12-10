package com.ltns.rest_area.controller.user;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltns.rest_area.domain.user.UserDTO;
import com.ltns.rest_area.validator.user.UserValidation;

@RestController
public class UserRestController {
	
	
	
	
//	
//	@레스트 콘트롤러
//	
//	@메소드맵핑주소("/auth/.........")      모든 권한
//	@메소드맵핑주소("/member/.........")    회원 권한
//	@메소드맵핑주소("/admin/.........")     관리자 권한   
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//	@PostMapping("/auth/user/lookUp")
//	@PostMapping("/auth/user/join")
//	public void userJoin(@Valid UserDTO user, BindingResult bindingResult) {
//
//		if (bindingResult.hasErrors()) {
//
//		} else {
//			try {
//
//			} catch (Exception e) {
//				System.out.println("디비 입력");
//			}
//		}
//
//	}	
//	@PostMapping("/member/user/lookUp")
//	@PutMapping("/member/user/modify")
//	@DeleteMapping("/member/user/delete")

	@InitBinder
	public void intBinder(WebDataBinder webDataBinder) {
		webDataBinder.setValidator(new UserValidation());
	}
}
