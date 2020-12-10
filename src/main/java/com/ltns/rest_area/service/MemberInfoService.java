package com.ltns.rest_area.service;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltns.rest_area.domain.DAO;
import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.memberInfo.memberInfoDAO;

@Service
public class MemberInfoService {
	
	
	DAO dao;

	@Autowired
	private SqlSession sqlSession;

	//list 
	public List<DTO> list(int from,int pagenationPage) {
		dao = sqlSession.getMapper(memberInfoDAO.class);
		return dao.selectFromRow(from, pagenationPage);
	}
	
	
	//모든 회원수 
	public int countAll() {
		dao = sqlSession.getMapper(memberInfoDAO.class);
		return dao.selectCnt();
	}
	
}
