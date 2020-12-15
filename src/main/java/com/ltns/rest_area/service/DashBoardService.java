package com.ltns.rest_area.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltns.rest_area.domain.DAO;
import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.admin.DashBoardDAO;

@Service
public class DashBoardService {

	
	@Autowired
	SqlSession sqlSession;
	
	
	DAO dao;
	
	public int total_acount(){
		dao = sqlSession.getMapper(DashBoardDAO.class);
		return dao.selectCnt();
	}
	
	
}
