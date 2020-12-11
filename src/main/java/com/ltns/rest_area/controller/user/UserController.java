package com.ltns.rest_area.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/auth/user/login")
	public void login() {
	}

	@RequestMapping("/auth/user/lookupid")
	public void lookupid() {
	}

	@RequestMapping("/auth/user/lookuppw")
	public void lookuppw() {
	}

	@RequestMapping("/auth/user/join")
	public void join() {
	}

	@RequestMapping("/member/user/info")
	public void info() {
	}

	@GetMapping("/member/user/mypage")
	public void mypage() {
	}
}
