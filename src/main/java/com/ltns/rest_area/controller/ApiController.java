package com.ltns.rest_area.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ApiController {
	
	@RequestMapping("/allapi")
	public String requestAllApi() {
		
		
		return ".";
	}
}
