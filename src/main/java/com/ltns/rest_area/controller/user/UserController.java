package com.ltns.rest_area.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/auth/user/login")
	public void login() {}

}
