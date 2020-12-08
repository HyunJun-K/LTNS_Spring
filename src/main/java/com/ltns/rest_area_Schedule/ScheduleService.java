package com.ltns.rest_area_Schedule;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

	
	@Autowired
	private ScheduleDAO dao;
	
	public List<ScheduleDTO> showSchedule()  {
		return dao.showSchedule();
	}
	
	
	public void addSchedule(ScheduleDTO dto) {
		dao.addSchedule(dto);
	}

	
		
}
