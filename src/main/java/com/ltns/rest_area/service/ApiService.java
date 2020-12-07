package com.ltns.rest_area.service;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltns.rest_area.domain.DAO;
import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.restarea.RestAreaDAO;

@Service
public class ApiService {
	DAO dao;
	
	@Autowired
	private SqlSession sqlSessionTemplate;
	
	@Transactional
	public int insertByDTOs(DTO[] dtos) throws Exception {
		int result=0;
		dao=sqlSessionTemplate.getMapper(RestAreaDAO.class);
		
		for(DTO dto : dtos ) {
			result=dao.insertByDTO(dto);
			if(result==0) {
				System.out.println("실패");
				throw new Exception();
			}
		}
		
		return result;
	};

}
