package com.ltns.rest_area.sample_maker.domain;

import java.sql.SQLException;
import java.util.List;

import com.ltns.rest_area.domain.DAO;
import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.VO;

public class MemberMakeDAO extends AbstractDAO {

	final static String DELETE_ALL_USERMEMBER="";
	final static String INSERT_USERMEMBER_RAMDOM="";
	final static String INSERT_USER_AUTHORITY="";
	final static String SELECT_ALL_USER="";
	
	public MemberMakeDAO() {
		super();
	}
	
	//deleteAll : 멤버 전부 삭제
	public int deleteAll(){
		try {
			justExcuteBySQL(DELETE_ALL_USERMEMBER);
		} catch (SQLException e) {
			System.out.println("멤버 delete all 에러");
			e.printStackTrace();
		}
		return 0;
	}
	
	//makeMember(int num) : num 만큼 멤버 무작위 생성
	public void makeMember(int num) throws SQLException {
		
		
		for(int i=0;i<num;i++) {
			pstmt=conn.prepareStatement(INSERT_USERMEMBER_RAMDOM);
			pstmt.setInt(0, x);
			pstmt=conn.prepareStatement(INSERT_USER_AUTHORITY);
		}
	}	
	
	//그냥 sql문 실행하는 메서드
	public void justExcuteBySQL(String sql) throws SQLException {
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("에러! : "+sql);
			e.printStackTrace();
		}finally {
			conn.commit();
//			close();
		}
	}
	
	public List<DTO> selectAllUser(){
		
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
	public int selectCntByVO(VO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectCntByObject(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DTO> selectByInt(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DTO> selectByString(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DTO> selectByDTO(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DTO> selectByVO(VO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DTO> selectByObject(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertByDTO(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertByVO(VO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertByObject(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAllByDTOs(List<DTO> dtos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByDTO(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByVO(VO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByObject(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAllByDTOs(List<DTO> dtos) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int deleteByInt(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByString(String str) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByVO(VO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByObject(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByUid(int[] uids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DTO> selectFromRow(int from, int pagenationPage) {
		// TODO Auto-generated method stub
		return null;
	}

}
