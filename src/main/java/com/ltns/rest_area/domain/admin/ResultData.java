package com.ltns.rest_area.domain.admin;

import lombok.Data;

@Data
public class ResultData {
	int count;	// 데이터 개수
	int totalCounts;
	String status;	// 처리결과
	String message;	// 결과 메세지
}
