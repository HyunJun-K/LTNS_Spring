package com.ltns.rest_area.controller;

import java.util.List;
import java.util.Map;

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

import com.ltns.rest_area.domain.AjaxList;
import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.memberInfo.memberInfoDTO;
import com.ltns.rest_area.service.MemberInfoService;
import com.ltns.rest_area.service.ScheduleService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	String subject;
	String startdate;
	String enddate;
	String memo;
	String addSubject;
	
	
	@Autowired
	ScheduleService service;


	int pageNo = 0;
	int pagenationPage = 0;
	
	@Autowired
	MemberInfoService member_service;

	
	
	
	@RequestMapping("/dashboard")
	public void dashboard() {}
	
	
	
	
	
	
	//일정 
	@PostMapping("/schedule")
	@ResponseBody
	public void addSchedule(@RequestBody Map<String, Object> datas) {
	
		for (Map.Entry<String, Object> data: datas.entrySet()) {
			
			if(data.getKey().equals("subject")) {
				subject = (String) data.getValue();
			}else if( data.getKey().equals("startDate")) {
				startdate = (String) data.getValue();
			}else if( data.getKey().equals("endDate")) {
				enddate = (String) data.getValue();
			}else {
				memo = (String) data.getValue();
			}
		}
	
		service.addSchedule(subject, startdate, enddate, memo);
	
	}
	
	//delete 
	@DeleteMapping("/schedule")
	@ResponseBody
	public void deleteSchedule(@RequestBody Map<String, Object> datas) {
	
		for (Map.Entry<String, Object> data: datas.entrySet()) {
			
			if(data.getKey().equals("subject")) {
				subject = (String) data.getValue();
			}
		}
	
		service.deleteSchedule(subject);
	
	}
	
	
	//update PUT
	@PutMapping("/schedule")
	@ResponseBody
	public void updateSchedule(@RequestBody Map<String, Object> datas) {
	
		for (Map.Entry<String, Object> data: datas.entrySet()) {
			
			if(data.getKey().equals("subject")) {
				subject = (String) data.getValue();
			}else if( data.getKey().equals("startDate")) {
				startdate = (String) data.getValue();
			}else if( data.getKey().equals("endDate")) {
				enddate = (String) data.getValue();
			}else if( data.getKey().equals("add_subject")){
				addSubject = (String) data.getValue();
			}else {
				memo = (String) data.getValue();
			}
		}
	
		System.out.println(addSubject + subject + startdate + enddate + memo);
		service.updateSchedule(addSubject, subject, startdate, enddate, memo);
	
	}
	
	
	@RequestMapping("/schedule")
	public void schedule(Model m) throws Exception
	{
		m.addAttribute("showSchedule", service.showSchedule());
		
	}
	
	
	
	@RequestMapping("/schedulePopup")
	public void Popup()	{}
	
	@RequestMapping("/deletePopup")
	public void deletePopup()	{}
	
	@RequestMapping("/updatePopup")
	public void updatePopup()	{}
	
	//회원정보 
	

	
	@RequestMapping("/memberInfo")
	public void ll () {
		
	}
	
	@GetMapping("/memberInfo/{pageNo}/{pagenationPage}")
	//@ResponseBody
	public AjaxList list(@PathVariable int pageNo, @PathVariable int pagenationPage ) {
	//public AjaxList list(@RequestBody Map<String, Integer> datas) {
		
		
		StringBuffer message = new StringBuffer();
		String status ="FAIL";
		
		
		int totalPage = 0;	//총 페이지 갯수
		int WritePages = 0; //총 리스트 수
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
		
		
		System.out.println(result);
		return result;
		
	} // end page
	
}
