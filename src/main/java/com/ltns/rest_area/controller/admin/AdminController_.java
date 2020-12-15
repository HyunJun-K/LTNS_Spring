package com.ltns.rest_area.controller.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltns.rest_area.domain.AjaxList;
import com.ltns.rest_area.domain.AjaxResult;
import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.admin.ScheduleDTO;
import com.ltns.rest_area.service.ScheduleService;

@RequestMapping(value="/admin")
@Controller
public class AdminController_ {

	
	
	@Autowired
	ScheduleService service;
	

	@RequestMapping("/dashboard")
	public void dashboard() {}
	
	
	
	//일정 
	
	

	
	
	
	
	//update PUT
	
	
	
	
	
	
	
	
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
	
	@RequestMapping("/memberInfo")
	public void memberInfo()	{}
	
	@RequestMapping("/postInfo")
	public void postInfo()	{}
	
	
	
}
