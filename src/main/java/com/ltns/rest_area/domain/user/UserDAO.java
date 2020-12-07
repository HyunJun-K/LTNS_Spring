package com.ltns.rest_area.domain.user;

import java.util.List;

public interface UserDAO {

	int joinUser(UserDTO user);

	int deleteUser(String username);

	int updateUser(UserDTO user);

	List<UserDTO> allUserList();

	UserDTO loginUserFindByUid(UserDTO user);

	UserDTO myPageFindByUid(String username);

}
