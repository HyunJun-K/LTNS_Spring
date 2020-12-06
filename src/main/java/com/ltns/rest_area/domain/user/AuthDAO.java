package com.ltns.rest_area.domain.user;

public interface AuthDAO {

	int joinAuth(String uesrname);

	AuthDTO findByUid(String username);

	int addAuth(String username, String authority);

	int removeAuthByUid(String username);

	int removeAuthByUidAndAuthority(String username, String authority);

	int updateAuth(String username, String authority);

}
