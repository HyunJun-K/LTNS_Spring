package com.ltns.rest_area.domain;

import java.util.List;

public interface DAO {
	/*select*/
	List<DTO> select();
	List<DTO> selectByInt(int i);
	List<DTO> selectByString(String s);
	List<DTO> selectByDTO(DTO dto);
	List<DTO> selectByObject(Object obj);
	
	/*insert*/
	int insertByDTO(DTO dto);
	int insertByObject(Object obj);
	
	/*update*/
	int updateByDTO(DTO dto);
	int updateByObject(Object obj);
	
	/*delete*/
	int deleteByInt(int i);
	int deleteByDTO(DTO dto);
	int deleteByObject(Object obj);
}
