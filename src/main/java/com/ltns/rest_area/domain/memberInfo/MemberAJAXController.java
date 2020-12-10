package com.ltns.rest_area.domain.memberInfo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltns.rest_area.domain.AjaxList;
import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.service.MemberInfoService;

@RestController
@RequestMapping("/admin")
public class MemberAJAXController {

	
	

	int pageNo = 0;
	int pagenationPage = 0;
	
	@Autowired
	MemberInfoService member_service;
	
	
	@PostMapping("memberInfo")
	//@GetMapping("/memberInfo/{pageNo}/{pagenationPage}")
	@ResponseBody
	public AjaxList list(
			@RequestBody Map<String, Integer> datas ) {
	
		for (Map.Entry<String, Integer> data: datas.entrySet()) {
			if(data.getKey().equals("pageNo")) {
				pageNo = data.getValue();
			}else if(data.getKey().equals("pageNo")) {
				pagenationPage = data.getValue();
			}
		
		}
		
		
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
