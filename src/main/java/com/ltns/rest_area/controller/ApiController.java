package com.ltns.rest_area.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.restarea.RestAreaDTO;
import com.ltns.rest_area.service.ApiService;

@Controller
@RequestMapping("/api")
public class ApiController {
	
	@RequestMapping("/allapi")
	public String requestAllApi() {
		try {
			new ApiService().insertByDTOs(new DTO[] {new RestAreaDTO().builder().ra_code(1).build()});
		} catch (Exception e) {
			System.out.println("db에러");
			e.printStackTrace();
		}
		
		return ".";
	}
}
