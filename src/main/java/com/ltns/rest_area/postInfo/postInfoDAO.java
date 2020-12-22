package com.ltns.rest_area.postInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ltns.rest_area.domain.DAO;
import com.ltns.rest_area.domain.DTO;

public interface postInfoDAO extends DAO{
	List<DTO> selectAlls();	//dao 상속받아서 써버리깅
	List<DTO> Allselect();	//dao 상속받아서 써버리깅
	List<DTO> selectByInts(int id);
	int allselect();
	
	public List<DTO> select_Rows(
			@Param("from") int from, @Param("pagenationPage") int pagenationPage
	);
	
}
