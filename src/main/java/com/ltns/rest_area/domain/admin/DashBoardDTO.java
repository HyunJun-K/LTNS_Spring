package com.ltns.rest_area.domain.admin;

import com.ltns.rest_area.domain.DTO;

import lombok.Data;

@Data
public class DashBoardDTO implements DTO {

	// 총합
	private int total_acount;	 // 총 회원수 
	private int total_post;      //총 게시물 수
	private int total_coment;	// 총합 댓글 
	
	
	// 일일 총 갯수 
	private int today_acount;    //오늘 가입한 회원 수 총합
	private int today_post;		 //오늘 작성된 글 수 
	private int today_report;	 //금일 신고된 신고 갯수
	private int today_coment;	 //오늘 작성된 댓글
	
	
	
}
