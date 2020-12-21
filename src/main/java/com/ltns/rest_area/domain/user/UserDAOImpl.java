package com.ltns.rest_area.domain.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.restarea.FoodMenuDTO;
import com.ltns.rest_area.domain.restarea.GasStationDTO;
import com.ltns.rest_area.domain.restarea.RestAreaDTO;

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
		return session.getMapper(UserDAO.class).updateAllByUsername(user);
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

	@Override
	public int deleteByPost_like(UserDTO user) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).deleteByPost_like(user);
	}

	@Override
	public int deleteByPOST(UserDTO user) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).deleteByPOST(user);
	}

	@Override
	public int deleteByFM_like(UserDTO user) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).deleteByFM_like(user);
	}


	@Override
	public int deleteByGS_like(UserDTO user) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).deleteByGS_like(user);
	}

	@Override
	public int deleteByRA_like(UserDTO user) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).deleteByRA_like(user);
	}


	@Override
	public int deleteByComments(UserDTO user) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).deleteByComments(user);
	}

	@Override
	public List<LikeDTO> findByRA_like_All(UserDTO user) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).findByRA_like_All(user);
	}

	@Override
	public List<LikeDTO> findByGS_like_All(UserDTO user) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).findByGS_like_All(user);
	}

	@Override
	public List<LikeDTO> findByFM_like_All(UserDTO user) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).findByFM_like_All(user);
	}

	@Override
	public List<LikeDTO> findByPost_like_All(UserDTO user) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).findByPost_like_All(user);
	}

	@Override
	public List<LikeDTO> findByPost_All(UserDTO user) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).findByPost_All(user);
	}

	@Override
	public List<LikeDTO> findByComment_All(UserDTO user) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).findByComment_All(user);
	}

	@Override
	public List<LikeDTO> findByRA_like(UserDTO user, int from, int to) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).findByRA_like(user, from, to);
	}

	@Override
	public List<LikeDTO> findByGS_like(UserDTO user, int from, int to) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).findByGS_like(user, from, to);
	}

	@Override
	public List<LikeDTO> findByFM_like(UserDTO user, int from, int to) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).findByFM_like(user, from, to);
	}

	@Override
	public List<LikeDTO> findByPost_like(UserDTO user, int from, int to) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).findByPost_like(user, from, to);
	}

	@Override
	public List<LikeDTO> findByPost(UserDTO user, int from, int to) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).findByPost(user, from, to);
	}

	@Override
	public List<LikeDTO> findByComments(UserDTO user, int from, int to) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).findByComments(user, from, to);
	}

	@Override
	public List<FoodMenuDTO> findByFoodMenu(LikeDTO like) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).findByFoodMenu(like);
	}

	@Override
	public List<GasStationDTO> findByGasStation(LikeDTO like) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).findByGasStation(like);
	}

	@Override
	public List<RestAreaDTO> findByRestArea(LikeDTO like) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).findByRestArea(like);
	}

	@Override
	public void findByLikePost(LikeDTO like) {
		// TODO Auto-generated method stub
		// return session.getMapper(UserDAO.class).findByLikePost(like);
	}

	@Override
	public int deleteStrLike(long uid, String table, String column, String[] strCode) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).deleteStrLike(uid, table, column, strCode);
	}

	@Override
	public int deleteNumLike(long uid, String table, String column, int[] numCode) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDAO.class).deleteNumLike(uid, table, column, numCode);
	}


	




}
