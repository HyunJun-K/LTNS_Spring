package com.ltns.rest_area.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltns.rest_area.domain.DAO;
import com.ltns.rest_area.domain.DTO;

@Service
public class SearchService {
	
	DAO dao;

	@Autowired
	private SqlSession sqlSession;


	
}
