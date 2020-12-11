package com.ltns.rest_area.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltns.rest_area.domain.AjaxList;
import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.memberInfo.memberInfoDTO;
import com.ltns.rest_area.service.MemberInfoService;
import com.ltns.rest_area.service.PostInfoService;
import com.ltns.rest_area.service.ScheduleService;

@RestController
@RequestMapping(value="/admin")
public class AdminController {
	


	int pageNo = 0;
	int pagenationPage = 0;
	
	@Autowired
	MemberInfoService member_service;
	
	
	@Autowired
	PostInfoService post_service;


	@GetMapping("/memberInfo/{pageNo}/{pagenationPage}")
	@ResponseBody
	public AjaxList list(
			@PathVariable int pageNo,	//현재 페이지
			@PathVariable int pagenationPage	) {
	
		
		
		
		StringBuffer message = new StringBuffer();
		String status ="FAIL";
		
		
		int totalPage = 0;	//총 페이지 갯수
		int WritePages = 10; //총 리스트 수
		int totalCnt = 0; //총 회원수 
		List<DTO> list = null;
		
		
		try {

			totalCnt = member_service.countAll();
			totalPage = (int)Math.ceil(totalCnt / (double)pagenationPage);
			
			int from = ( pageNo - 1 ) * pagenationPage +1;
			list = member_service.list(from, pagenationPage);
			
			if(list == null) {
				message.append("[List data is not defind]");
			} else {
				status = "OK";
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			message.append("[Error]" + e.getMessage());
		}
		
		AjaxList result = new AjaxList();
		
		result.setStatus(status);
		result.setMessage(message.toString());
		
		if(list != null) {
			result.setCount(list.size());
			result.setList(list);
		}
		
		result.setPageNo(pageNo);
		result.setTotalPage(totalPage);
		result.setWritePages(WritePages);
		result.setPagenationPage(pagenationPage);
		result.setTotalCnt(totalCnt);
		
		
		
		return result;
		
	} // end page
	
	
	
	@DeleteMapping("")
	@ResponseBody
	public AjaxList Serach(@RequestBody Map<String, String> data) {
	
			String name = "";
			String nick = "";
	
		for (Entry<String, String> datas : data.entrySet()) {
				if(datas.getKey().equals("option")) {
					name = datas.getValue();
					
				}else {
					nick = datas.getValue();
				
				}
					
		}
		
		
		System.out.println(name + "아이디 " + " : " +  "nick:" + nick);
		
		
		
		
		StringBuffer message = new StringBuffer();
		String status ="FAIL";
		
		
		List<DTO> list = null;
		
		try {

			
			list = member_service.seachId(nick);
			
			if(list == null) {
				message.append("[List data is not defind]");
			} else {
				status = "OK";
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			message.append("[Error]" + e.getMessage());
		}
		
		AjaxList result = new AjaxList();
		
		result.setStatus(status);
		result.setMessage(message.toString());
		
		if(list != null) {
			result.setCount(list.size());
			result.setList(list);
		}
		
	
		return result;
		
	} // end page
	
	
	
	
	
	
	
	
	
	
	
	
	//PostInfo
	@GetMapping("/postInfo/{pageNo}/{pagenationPage}")
	@ResponseBody
	public AjaxList postList(
			@PathVariable int pageNo,	//현재 페이지
			@PathVariable int pagenationPage) {
	
		
		
		
		StringBuffer message = new StringBuffer();
		String status ="FAIL";
		
		
		int totalPage = 0;	//총 페이지 갯수
		int WritePages = 10; //총 리스트 수
		int totalCnt = 0; //총 회원수 
		List<DTO> list = null;
		
		
		try {

			totalCnt = post_service.countAll();
			totalPage = (int)Math.ceil(totalCnt / (double)pagenationPage);
			
			int from = ( pageNo - 1 ) * pagenationPage +1;
			list = post_service.list(from, pagenationPage);
			
			if(list == null) {
				message.append("[List data is not defind]");
			} else {
				status = "OK";
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			message.append("[Error]" + e.getMessage());
		}
		
		AjaxList result = new AjaxList();
		
		result.setStatus(status);
		result.setMessage(message.toString());
		
		if(list != null) {
			result.setCount(list.size());
			result.setList(list);
		}
		
		result.setPageNo(pageNo);
		result.setTotalPage(totalPage);
		result.setWritePages(WritePages);
		result.setPagenationPage(pagenationPage);
		result.setTotalCnt(totalCnt);
		
		
		
		return result;
		
	} // end page
	
	
	
	//상위5개 데이터 불러오기 

	@PostMapping("Toplist")
	public AjaxList ListTop() {
	
		
		StringBuffer message = new StringBuffer();
		String status ="FAIL";
		
		
		List<DTO> list = null;
		
		try {

			list = post_service.listTop();
			
			if(list == null) {
				message.append("[List data is not defind]");
			} else {
				status = "OK";
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			message.append("[Error]" + e.getMessage());
		}
		
		AjaxList result = new AjaxList();
		
		result.setStatus(status);
		result.setMessage(message.toString());
		
		if(list != null) {
			result.setCount(list.size());
			result.setList(list);
		}
		
	
		return result;
		
	} // end page
	
	
	
	
	
	
	
}
