package com.ltns.rest_area.domain.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.ltns.rest_area.domain.DTO;

public class UserDAOImpl implements UserDAO {

	@Autowired
	SqlSession session;

	@Override
	public List<DTO> selectAll() {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).selectAll();
	}
	
	@Override
	public List<UserDTO> findByNickname(UserDTO user) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).findByNickname(user);
	}

	@Override
	public List<DTO> selectByObject(Object obj) {
		UserDTO user = (UserDTO) obj;
		return session.getMapper(UserDAO.class).selectByObject(user);
	}

	@Override
	public List<DTO> selectByString(String s) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).selectByString(s);
	}

	@Override
	public int insertByObject(Object obj) {
		// TODO Auto-generated method stub
		UserDTO user = (UserDTO) obj;
		return session.getMapper(UserDAO.class).insertByObject(user);
	}

	@Override
	public int updateByObject(Object obj) {
		// TODO Auto-generated method stub
		UserDTO user = (UserDTO) obj;
		return session.getMapper(UserDAO.class).updateByObject(user);
	}
	

	@Override
	public int updateAllByUsername(UserDTO user) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int updateByDTO(DTO dto) {
		// TODO Auto-generated method stub
		UserDTO user = (UserDTO) dto;
		return session.getMapper(UserDAO.class).updateByDTO(user);
	}


	@Override
	public int deleteByObject(Object obj) {
		// TODO Auto-generated method stub
		UserDTO user = (UserDTO) obj;
		return session.getMapper(UserDAO.class).deleteByObject(user);
	}



	@Override
	public List<DTO> selectByDTO(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertByDTO(DTO dto) {
		return 0;
	}

	@Override
	public int test(String s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByInt(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DTO> selectByInt(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertAllByDTOs(List<DTO> dtos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inset_(String s, String d, String e, String dd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAllByDTOs(List<DTO> dtos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update_(String a, String s, String d, String e, String dd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByString(String str) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectCntByInt(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectCntByString(String str) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectCntByObject(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DTO> selectFromRow(int from, int pagenationPage) {
		// TODO Auto-generated method stub
		return null;
	}




}
