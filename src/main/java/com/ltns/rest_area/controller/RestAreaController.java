package com.ltns.rest_area.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltns.rest_area.service.SearchService;

@Controller
@RequestMapping("/restarea")
public class RestAreaController {

	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/restarea")
	public void restarealist() {
		searchService.
	}
}
