
package com.ltns.rest_area.domain;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ltns.rest_area.domain.restarea.RestAreaDTO;

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
	int insertAllByDTOs(List<DTO> dtos);
	
	int test(String s);
	
	
	/*update*/
	int updateByDTO(DTO dto);
	int updateByObject(Object obj);
	int updateAllByDTOs(List<DTO> dtos);

	
	/*delete*/
	int deleteByInt(int i);
	int deleteByDTO(DTO dto);
	int deleteByObject(Object obj);
	int deleteAll();

}

