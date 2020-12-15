package com.ltns.rest_area.domain.admin;

import com.ltns.rest_area.domain.DTO;

import lombok.Data;

@Data
public class DashBoardDTO implements DTO {

	
	private int total_acount;	// 총 회원수 
	private int total_post; //총 게시물 수

}
