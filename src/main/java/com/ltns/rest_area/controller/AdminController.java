package com.ltns.rest_area.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.admin.AjaxResult;
import com.ltns.rest_area.service.ScheduleService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	
	@Autowired
	ScheduleService service;
	
	
	@PostMapping("/addSchedule")
	public	int addSchedule ( DTO dto) throws Exception {
		int cnt = 0; 
		cnt = service.addSchedule(dto);
		return cnt;
	}
//		StringBuffer message = new StringBuffer();
//		String status = "FAIL";
//		int cnt = 0;
//		try {
//			cnt = service.addSchedule(dto);
//			if(cnt == 0) {
//				message.append("트랜잭션 실패 : 0");
//			}else {
//				status = "OK";
//			}
//		} catch (Exception e) {
//			message.append("트랜잭션 에러:" + e.getMessage());
//		}
//		
//		AjaxResult result = new AjaxResult();
//		result.setStatus(status);
//		result.setMessage(message.toString());
//		result.setCount(cnt);
//		return result;
//		
	
	
	@RequestMapping("/schedule")
	public void schedule(Model m) throws Exception
	{
		m.addAttribute("showSchedule", service.showSchedule());
		
	}
	
	
	
	@RequestMapping("/schedulePopup")
	public void Popup()	{}
	
	
	
}
