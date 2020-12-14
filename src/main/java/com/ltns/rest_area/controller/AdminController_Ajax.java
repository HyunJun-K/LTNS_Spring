package com.ltns.rest_area.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltns.rest_area.domain.AjaxList;
import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.service.MemberInfoService;
import com.ltns.rest_area.service.PostInfoService;

@RestController
@RequestMapping(value="/admin")
public class AdminController_Ajax {
	


	int pageNo = 0;
	int pagenationPage = 0;
	
	@Autowired
	MemberInfoService member_service;
	
	
	@Autowired
	PostInfoService post_service;


	
	// 멤버 정보 
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
	
	
	
	@DeleteMapping("SEACH")
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
	
	
	
	
	
	
	
	
	
	
	
	
	//PostInfo 정보
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
	
	
	@PostMapping("DELETEPOST")
	public AjaxList deleteOk(int [] post_id) {
		
		int cnt = 0;
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		try {
			if(post_id != null) {
				cnt = post_service.deletePost(post_id);
				status = "OK";
			}	
			
			if (cnt == 0) {
				message.append("없데이트 없음");
			}
		} catch (Exception e) {
			message.append("트랜잭션 에러" + e.getMessage());
		}
		
		
		AjaxList result = new AjaxList();
		result.setCount(cnt);
		result.setMessage(message.toString());
		result.setStatus(status);
		
		return result;
	}
	
	

	@DeleteMapping("SEACHPOSTINFO")
	@ResponseBody
	public AjaxList SEACHPOSTINFO(@RequestBody Map<String, String> data) {
	
			String nickname = "";
			String title = "";
			String contents ="";
		for (Entry<String, String> datas : data.entrySet()) {
			if(datas.getValue().equals("title")) {
				title = datas.getValue();
			}else if(datas.getKey().equals("content")) {
				contents = datas.getValue();
			}else if(datas.getValue().equals("nickName")) {
				nickname = datas.getValue();
			}
		}
		
		
		StringBuffer message = new StringBuffer();
		String status ="FAIL";
		
		
		List<DTO> list = null;
		
		try {
			if(title.equals(title)) {
				list = post_service.seachTitle(contents);
			}else {
				list =  post_service.seachNickname(contents);
			}
			
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