
package com.ltns.rest_area.domain;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ltns.rest_area.domain.admin.ScheduleDTO;
import com.ltns.rest_area.domain.restarea.RestAreaDTO;

public interface DAO {
	/*select*/
	List<DTO> select();
	List<DTO> selectByInt(int i);
	List<DTO> selectByString(String str);
	List<DTO> selectByDTO(DTO dto);
	List<DTO> selectByObject(Object obj);
	
	/*insert*/
	int insertByDTO(DTO dto);
	int insertByObject(Object obj);
	int insertAllByDTOs(List<DTO> dtos);
	
	//이단
	int test(String s);
	int inset_(String s, String d, String e, String dd);
	//builder 패턴을 잘 활용하면 dto를 통해 쉽게 보내기 가능..

	
	/*update*/
	int updateByDTO(DTO dto);
	int updateByObject(Object obj);
	int updateAllByDTOs(List<DTO> dtos);
	
	//이단
	int update_(String a, String s, String d, String e, String dd);

	
	/*delete*/
	int deleteByInt(int i);
	int deleteByString(String str);
	int deleteByDTO(DTO dto);
	int deleteByObject(Object obj);
	int deleteAll();

}

