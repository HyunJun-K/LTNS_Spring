package com.ltns.rest_area.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltns.rest_area_Schedule.ScheduleDTO;
import com.ltns.rest_area_Schedule.ScheduleService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	
	@Autowired
	ScheduleService service;
	
	
	@ResponseBody
	@RequestMapping(value= "/addSchedule", method = RequestMethod.POST)
	public Map<Object, Object> addSchedule(@RequestBody ScheduleDTO dto) throws Exception{
		 Map<Object, Object> map = new HashMap<Object, Object>();
		 service.addSchedule(dto);
		 return map;
	}
	

	
	@RequestMapping("/schedule")
	public void schedule(Model m) throws Exception
	{
		m.addAttribute("showSchedule", service.showSchedule());
		
	}
	
	
	
	@RequestMapping("/schedulePopup")
	public void Popup()	{	}
	
	
	
}
