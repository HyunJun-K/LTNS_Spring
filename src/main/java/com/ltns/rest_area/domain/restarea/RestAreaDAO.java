package com.ltns.rest_area.domain.restarea;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.ltns.rest_area.domain.DAO;
import com.ltns.rest_area.domain.DTO;

@MapperScan
public interface RestAreaDAO {
	/*select*/
	List<DTO> select();
	List<DTO> selectByInt(int i);
	List<DTO> selectByString(String s);
	List<DTO> selectByDTO(DTO dto);
	List<DTO> selectByObject(Object obj);
	
	/*insert*/
	int insertByDTO(DTO dto);
	int insertByObject(Object obj);
	int test(String s);
	
	/*update*/
	int updateByDTO(DTO dto);
	int updateByObject(Object obj);
	
	/*delete*/
	int deleteByInt(int i);
	int deleteByDTO(DTO dto);
	int deleteByObject(Object obj);
}
