package com.ltns.rest_area.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltns.rest_area.service.SearchService;

@Controller
@RequestMapping("/restarea")
public class RestAreaController {

	@Autowired
	private SearchService searchService;
	
	//휴게소로 검색
	@GetMapping("/{listSort}/{routeName}/{destination}/{orderBy}")
	public String getList(@PathVariable String listSort, @PathVariable String routeName, @PathVariable String destination, @PathVariable String orderBy) {
		String result="";
		
		switch (listSort) {
		case "ra":
			break;
		case "gs":
			break;
		case "fm":
			break;
		}
		
		return result;
	}
	
	
	//추가 리스트 호출(아래로 스크롤) lastIndex 이후부터 10개 추가
	@GetMapping("/{listSort}/{lastIndex}")
	public String moreList(@PathVariable String listSort, @PathVariable int lastIndex) {
		String result="";
		
		switch (listSort) {
		case "ra":
			break;
		case "gs":
			break;
		case "fm":
			break;
		}
		
		return result;
	}
	
	
}
