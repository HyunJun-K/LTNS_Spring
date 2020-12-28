package com.ltns.rest_area.service.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltns.rest_area.domain.DAO;
import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.admin.AreaDataDAO;

@Service
public class AreaDataService {

	
	
	@Autowired
	SqlSession sqlSession;
	
	DAO dao;
	AreaDataDAO vo;
	
	
	public List<DTO> selectFromRow(int from,int pagenationPage){
		dao = sqlSession.getMapper(AreaDataDAO.class);
		return dao.selectFromRow(from, pagenationPage);
	}
	
	public List<DTO> selectFromGasRow(int from,int pagenationPage){
		vo = sqlSession.getMapper(AreaDataDAO.class);
		return vo.selectFromGasRow(from, pagenationPage);
	}
	
	public List<DTO> selectFromMenuRow(int from,int pagenationPage){
		vo = sqlSession.getMapper(AreaDataDAO.class);
		return vo.selectFromMenuRow(from, pagenationPage);
	}
	
	
	
	public int AreaTotal() {
		dao = sqlSession.getMapper(AreaDataDAO.class);
		return dao.selectCnt();
	}
	
	public int GasTotal() {
		vo = sqlSession.getMapper(AreaDataDAO.class);
		return vo.SelectTotalGas();
	}
	
	public int MenuTotal() {
		vo = sqlSession.getMapper(AreaDataDAO.class);
		return vo.SelectTotalMenu();
	}
}
