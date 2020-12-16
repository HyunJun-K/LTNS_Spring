package com.ltns.rest_area.domain.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AjaxList extends com.ltns.rest_area.domain.AjaxList{
	
	@JsonProperty("data")
	List listAll;
}
