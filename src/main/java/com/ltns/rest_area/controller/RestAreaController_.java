package com.ltns.rest_area.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestAreaController_ {
	@GetMapping("/rest_area/list")
	public String page() {return "/restarea/list";}
	
}
