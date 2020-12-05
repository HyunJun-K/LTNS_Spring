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
public class RestAreaDTO implements DTO{
	private int ra_code;
	private String ra_name;
	private String ra_direction;
	private String ra_route;
	private String ra_comment;
}
