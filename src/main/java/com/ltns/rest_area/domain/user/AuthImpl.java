package com.ltns.rest_area.domain.user;

import com.ltns.rest_area.domain.DTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthImpl implements AuthDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override 
    public int insertByObject(Object obj) {
        long uid = (long) obj;
        return sqlSession.getMapper(AuthDAO.class).insertByObject(uid);
    }

    @Override 
    public int deleteByObject(Object obj) {
        long uid = (long) obj;
        return sqlSession.getMapper(AuthDAO.class).deleteByObject(uid);
    }

    @Override
    public List<DTO> select() {
        return null;
    }

    @Override
    public List<DTO> selectByInt(int i) {
        return null;
    }

    @Override
    public List<DTO> selectByString(String s) {
        return null;
    }

    @Override
    public List<DTO> selectByDTO(DTO dto) {
        return null;
    }

    @Override
    public List<DTO> selectByObject(Object obj) {
        return null;
    }

    @Override
    public int insertByDTO(DTO dto) {
        return 0;
    }


    @Override
    public int test(String s) {
        return 0;
    }

    @Override
    public int updateByDTO(DTO dto) {
        return 0;
    }

    @Override
    public int updateByObject(Object obj) {
        return 0;
    }

    @Override
    public int deleteByInt(int i) {
        return 0;
    }

    @Override
    public int deleteByDTO(DTO dto) {
        return 0;
    }

    @Override
    public int deleteAll() {
        return 0;
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
}
