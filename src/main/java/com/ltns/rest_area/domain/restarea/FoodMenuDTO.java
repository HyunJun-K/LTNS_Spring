package com.ltns.rest_area.domain.restarea;

import com.ltns.rest_area.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FoodMenuDTO implements DTO {
	private int fm_id;	//고유 음식 아이디(기본키)
	private int fm_code;	//음식 코드
	private int ra_code;	//휴게소 코드(외래키)
	private String fm_name;
	private String fm_price;
}
