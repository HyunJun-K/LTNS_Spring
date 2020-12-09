package com.ltns.rest_area.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AjaxList {
	
	@JsonProperty("count")
	int count;	//총 dto 갯수

	@JsonProperty("pageNo")
	int pageNo;		//현재 페이지
	@JsonProperty("numOfRows")
	int numOfRows; 	//한 페이지에 리스트할 dto 갯수
	@JsonProperty("totalPage")
	int totalPage;	//총 페이지 갯수
	
	@JsonProperty("list")
	List<DTO> list;	//dto 데이터

	@JsonProperty("pagenationPage")
	int pagenationPage;	//페이지네이션에 표시할 페이지 갯수
}
