package com.ltns.rest_area.controller.admin;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.ibatis.executor.ReuseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltns.rest_area.domain.AjaxList;
import com.ltns.rest_area.domain.AjaxResult;
import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.memberInfo.mailDTO;
import com.ltns.rest_area.service.MemberInfoService;

@RestController
@RequestMapping(value="/admin")
public class AdminMeberAjaxController {


	int pageNo = 0;
	int pagenationPage = 0;
	
	
	@Autowired
	MemberInfoService member_service;
	
	@Autowired
	JavaMailSender mailSender;
	
	
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
	
	
	// 검색 
	@DeleteMapping("SEACH")
	@ResponseBody
	public AjaxList Serach(@RequestBody Map<String, String> data) {
	
			String id = "";
			String nickname = "";
			String contents ="";
			
		for (Entry<String, String> datas : data.entrySet()) {
			if(datas.getValue().equals("id")) {
				id = datas.getValue();
			}else if(datas.getKey().equals("text")) {
				contents = datas.getValue();
			}else if(datas.getValue().equals("nickName")) {
				nickname = datas.getValue();
			}
		}
		StringBuffer message = new StringBuffer();
		String status ="FAIL";
		
		
		List<DTO> list = null;
		
		try {

			if(id.equals(id)) {
				list = member_service.seachId(contents);
			}else if(nickname.equals("nickName")){
				list = member_service.seachNickname(contents); 
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
	
	//가장많은 댓글을 단 회원 
	
	@PostMapping("TopComent")
	public AjaxResult TopComent() {
		
		StringBuffer message = new StringBuffer();
		String status ="FAIL";
		List<DTO> list = null;
		
		try {

			list = member_service.serachComents();
			
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
		
	}
	
	
	//가장 많은글을 쓴유저 
	
	@GetMapping("TopPostUser")
	public AjaxResult TopPostUser() {
		StringBuffer message = new StringBuffer();
		String status= "FAIL";
		
		List<DTO> list = null;
		try {
			list = member_service.serachPost();
			if(list == null) {
				message.append("[List data is not defind]");
			} else {
				status = "OK";
			}
			
		} catch (Exception e) {
			message.append("트랜잭션 오류" + e.getMessage());
		}
	
		AjaxList result = new AjaxList();
		result.setMessage(message.toString());
		result.setStatus(status);
		
		
		if(list != null) {
			result.setCount(list.size());
			result.setList(list);
		}
		
		
		return result;
	}
	
	
	
	
	
	
	@PostMapping("mailSendAjax")
	public AjaxResult mailSend(@RequestBody mailDTO dto) {
		
		MimeMessage message = mailSender.createMimeMessage();
		AjaxResult result = new AjaxResult();
		String status = "FAIL";
		
		try {
			message.setSubject(dto.getTitle());// 제목
			message.setRecipient(RecipientType.TO , new InternetAddress(dto.getUsername())); // 수신자
			message.setText(dto.getTextMail());
			
			mailSender.send(message);
			status = "OK";
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result.setStatus(status);
		
		
		return result;
		
	}

	
	
	
	
	
	
}
