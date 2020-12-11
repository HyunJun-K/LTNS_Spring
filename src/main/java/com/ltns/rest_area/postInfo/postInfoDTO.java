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
	private String UM_USERNAME;  
	private String post_regdate;
	private String post_contents;
	private String RA_code;
	private String post_reported;
	
	
}
