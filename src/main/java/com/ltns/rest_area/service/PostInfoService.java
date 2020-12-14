package com.ltns.rest_area.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltns.rest_area.domain.DAO;
import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.memberInfo.memberInfoDAO;
import com.ltns.rest_area.postInfo.postInfoDAO;
import com.ltns.rest_area.postInfo.postInfoDTO;

@Service
public class PostInfoService {

	
	
	@Autowired
	SqlSession sqlSession;
	
	DAO dao;
	
	
	
	//list 
	public List<DTO> list(int from,int pagenationPage) {
		dao = sqlSession.getMapper(postInfoDAO.class);
		return dao.selectFromRow(from, pagenationPage);
	}
	
	
	//모든 게시글
		public int countAll() {
			dao = sqlSession.getMapper(postInfoDAO.class);
			return dao.selectCnt();
	}
		
		
	//신고가 많은 상위 5개의 데이터 
		
		
	public List<DTO> listTop() {
		dao = sqlSession.getMapper(postInfoDAO.class);
		return dao.selectAll();
	}
	
	
	public int deletePost (int [] post_id) {
		dao = sqlSession.getMapper(postInfoDAO.class);
		return dao.deleteByUid(post_id);
	}

	public List<DTO> seachTitle(String title) {
		dao = sqlSession.getMapper(postInfoDAO.class);
		return dao.selectByString(title);
	}
	
	public List<DTO> seachNickname(String nickname) {
		dao = sqlSession.getMapper(postInfoDAO.class);
		return dao.selectByString(nickname);
	}
	
	
	
}
