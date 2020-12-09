package com.ltns.rest_area.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AjaxResult {
	private int count; //데이터 개수
	private String Status; //처리 결과
	private String message; //결과 메세지
}
