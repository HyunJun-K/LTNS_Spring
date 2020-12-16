package com.ltns.rest_area.domain.user;

import java.util.List;

import com.ltns.rest_area.domain.DAO;

public interface UserDAO extends DAO {

	List<UserDTO> findByNickname(UserDTO user);
	
	int updateAllByUsername(UserDTO user);

}
