package com.ltns.rest_area.service.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltns.rest_area.domain.DAO;
import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.postInfo.postInfoDAO;

@Service
public class NoticeService {
	
	
	postInfoDAO DAO;
	
	@Autowired
	private SqlSession sqlSession;
	
	//list 
	public List<DTO> list(int from,int pagenationPage) {
		DAO = sqlSession.getMapper(postInfoDAO.class);
		return DAO.select_Rows(from, pagenationPage);
	}
	
	public int selectTotal() {
		DAO = sqlSession.getMapper(postInfoDAO.class);
		return DAO.allselect();
	}
	
	public List<DTO> noticeView(int id){
		DAO = sqlSession.getMapper(postInfoDAO.class);
		return DAO.selectByInts(id);
	}
}
