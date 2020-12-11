package com.ltns.rest_area.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.user.UserDAO;
import com.ltns.rest_area.domain.user.UserDTO;

public class UserService {

	UserDAO userDAO;

	AuthService authService;

	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Autowired
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	@Autowired
	public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public List<UserDTO> findAll() {
		List<UserDTO> users = new ArrayList<UserDTO>();

		List<DTO> list = userDAO.selectAll();

		if (list != null)
			list.forEach(item -> users.add((UserDTO) item));

		return users;
	}

	public List<UserDTO> findByNickname(UserDTO dto) {
		List<UserDTO> user = userDAO.findByNickname(dto);
		return user;
	}

	public List<UserDTO> findByUid(UserDTO dto) {
		List<UserDTO> user = new ArrayList<UserDTO>();
		List<DTO> temp = userDAO.selectByObject(dto);
		if (temp != null && temp.size() != 0)
			user.add((UserDTO) temp.get(0));
		return user;
	}

	public List<UserDTO> findByUsername(UserDTO dto) {
		List<UserDTO> user = new ArrayList<UserDTO>();
		List<DTO> temp = userDAO.selectByString(dto.getUm_username());
		if (temp != null && temp.size() != 0)
			user.add((UserDTO) temp.get(0));
		return user;
	}

	public int insertUser(UserDTO user) {
		user.setUm_password(bCryptPasswordEncoder.encode(user.getUm_password()));
		int result = userDAO.insertByObject(user);
		List<UserDTO> users = findByUsername(user);

		if (result == 1) {
			long seq = users.get(0).getUm_uid();
			result = authService.insertAuth(seq);
		}
		return result;
	}

	public int updatePasswordByUesrname(UserDTO user) {
		user.setUm_password(bCryptPasswordEncoder.encode(user.getUm_password()));
		return userDAO.updateByObject(user);
	}

	public int updateNicknameByUesrname(UserDTO user) {
		return userDAO.updateByDTO(user);
	}

	public int updateAllByUsername(UserDTO user) {
		user.setUm_password(bCryptPasswordEncoder.encode(user.getUm_password()));
		return userDAO.updateAllByUsername(user);
	}

	public int deleteByUesrname(UserDTO user) {
		List<UserDTO> findUsers = findByUsername(user);
		UserDTO findUser = findUsers.get(0);

		int result = authService.deleteAuth(findUser.getUm_uid());

		if (result == 1)
			result = userDAO.deleteByObject(user);

		return result;
	}
}
