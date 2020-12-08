package com.ltns.rest_area.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.restarea.RestAreaDTO;

public class ApiServiceTest {

	@Test
	public void test() {
		ApiService apiservice=new ApiService();
		
		DTO dto=new RestAreaDTO().builder().ra_code(1).build();
		DTO[] dtos=new DTO[1];
		dtos[0]=dto;
		try {
			apiservice.insertByDTOs(dtos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
