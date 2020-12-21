package com.ltns.rest_area.postInfo;

import com.ltns.rest_area.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class postInfoDTO implements DTO {
	
	
	
	private int post_id;
	private String post_title;
	private String post_regdate;
	private String post_contents;
	private String post_reported;
	private String ra_code;
	private String um_USERNAME;
	
	private String days;
	private int dayscount;
	private int ACCOUNT;
	
	
}
