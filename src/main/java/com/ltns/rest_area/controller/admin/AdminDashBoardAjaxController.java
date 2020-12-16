package com.ltns.rest_area.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltns.rest_area.domain.AjaxList;
import com.ltns.rest_area.domain.AjaxResult;
import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.admin.ResultData;
import com.ltns.rest_area.service.DashBoardService;

@RestController
@RequestMapping(value="/admin")
public class AdminDashBoardAjaxController {

	
	@Autowired
	DashBoardService Dservice;
	
	
	
	@PostMapping("total_Acount")
	public AjaxResult total_Acount() {
		int cnt = 0; 
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		cnt = Dservice.total_acount();
		
		if(cnt == 0) {
			message.append("트랜잭션 실패 ");
		}else {
			status ="OK";
		}
		
		AjaxResult result = new AjaxResult();
		result.setCount(cnt);
		result.setMessage(message.toString());
		result.setStatus(status);
		return result;
	}
	
	
	@PostMapping("today_acount")
	public AjaxResult today_acount() {
		int cnt = 0; 
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		cnt = Dservice.today_acount();
		
		if(cnt == 0) {
			message.append("트랜잭션 실패 ");
		}else {
			status ="OK";
		}
		
		AjaxResult result = new AjaxResult();
		result.setCount(cnt);
		result.setMessage(message.toString());
		result.setStatus(status);
		return result;
	}
	

	@PostMapping("today_post")
	public AjaxResult today_post() {
		int cnt = 0; 
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		cnt = Dservice.today_post();
		
		if(cnt == 0) {
			message.append("트랜잭션 실패 ");
		}else {
			status ="OK";
		}
		
		AjaxResult result = new AjaxResult();
		result.setCount(cnt);
		result.setMessage(message.toString());
		result.setStatus(status);
		return result;
	}
	

	@PostMapping("total_post")
	public AjaxResult total_post() {
		int cnt = 0; 
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		cnt = Dservice.total_post();
		
		if(cnt == 0) {
			message.append("트랜잭션 실패 ");
		}else {
			status ="OK";
		}
		
		AjaxResult result = new AjaxResult();
		result.setCount(cnt);
		result.setMessage(message.toString());
		result.setStatus(status);
		return result;
	}
	

	@PostMapping("today_report")
	public AjaxResult today_report() {
		int cnt = 0; 
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		cnt = Dservice.today_report_post();
		
		if(cnt == 0) {
			message.append("트랜잭션 실패 ");
		}else {
			status ="OK";
		}
		
		AjaxResult result = new AjaxResult();
		result.setCount(cnt);
		result.setMessage(message.toString());
		result.setStatus(status);
		return result;
	}
	
	//팝업
	@PostMapping("repostPopup")
	public AjaxList todays_report_post(){
		
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		List<DTO> list = null; 
		
		try {
			list = Dservice.today_report_Popup();
			
			if(list != null) {
				status ="OK";
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
	}
	
	
	
	@PostMapping("today_coment")
	public ResultData comentsToInfo() {
		
		String status ="FAIL";
		StringBuffer message = new StringBuffer();
		ResultData result = new ResultData();
		int cnt = 0;
		int totalCounts = 0;
		try {
			cnt = Dservice.todayComent();
			totalCounts = Dservice.today_totalComent();
			
			if(cnt != 0) {
				status = "OK";
			}
			
			if(totalCounts != 0) {
				status = "OK";
			}
			
			
		} catch (Exception e) {
			message.append("트랜잭션오류 "+e.getMessage());
		}
		
		result.setCount(cnt);
		result.setStatus(status);
		result.setMessage(message.toString());
		result.setTotalCounts(totalCounts);
		
		
		return result;
	}
	
	
	
	
	
	
}
