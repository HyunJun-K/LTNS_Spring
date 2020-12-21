package com.ltns.rest_area.controller.admin;

import java.util.List;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltns.rest_area.domain.AjaxList;
import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.postInfo.postInfoDTO;
import com.ltns.rest_area.service.admin.NoticeService;

@RestController
@RequestMapping(value="/admin")
public class AdminNoticeAjaxController {

	
	
	@Autowired
	NoticeService service;
	
	@GetMapping("/notice/{pageNo}/{pagenationPage}")
	@ResponseBody
	public AjaxList noticeList(
			@PathVariable int pageNo,	//현재 페이지
			@PathVariable int pagenationPage) {
		
		
		StringBuffer message = new StringBuffer();
		String status ="FAIL";
		List<DTO> list = null;
		int  totalCnt = 0;
		int totalPage = 0;
		int WritePages = 10; 
		try {
			
			totalCnt = service.selectTotal();
			totalPage = (int)Math.ceil(totalCnt / (double)pagenationPage);
			
			int from = ( pageNo - 1 ) * pagenationPage +1;
			list = service.list(from, pagenationPage);
			
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
	
	}
	
	
	@GetMapping("/notice/{id}")
	public AjaxList noticeView(@PathVariable int id) {
		
	
		List<DTO> list = null; 
		StringBuffer message = new StringBuffer();
		String status ="FAIL";
		list = service.noticeView(id);
		try {
		
			
			if(list != null) {
				status ="OK";
			}
		} catch (Exception e) {
			message.append(e.getMessage() + "트랜잭션 오류");
		}
		
		AjaxList result = new AjaxList();
		
		result.setMessage(message.toString());
		result.setStatus(status);
		result.setList(list);
		
	
		
		
		
		return result;
	}
	
}
