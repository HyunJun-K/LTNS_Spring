
package com.ltns.rest_area.domain.admin;


import com.ltns.rest_area.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO implements DTO {
	
	private int uid;
	private String subject;
	private String startDate; 
	private String endDate;
	private String memo;
	
	
	
	
	
	
	
	
}
