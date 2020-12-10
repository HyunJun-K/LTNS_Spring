package com.ltns.rest_area.domain.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ltns.rest_area.domain.DTO;

@Component
public class AuthDAOImpl implements AuthDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override 
    public int insertByObject(Object obj) {
        long uid = (long) obj;
        return sqlSession.getMapper(AuthDAO.class).insertByObject(uid);
    }
    

    @Override
    public int insertByDTO(DTO dto) {
    	UserAuthDTO userAuth = (UserAuthDTO)dto;
        return sqlSession.getMapper(AuthDAO.class).insertByObject(userAuth);
    }


    @Override 
    public int deleteByObject(Object obj) {
        long uid = (long) obj;
        return sqlSession.getMapper(AuthDAO.class).deleteByObject(uid);
    }
    
    @Override
    public List<DTO> selectByObject(Object obj) {
    	 long uid = (long) obj;
        return sqlSession.getMapper(AuthDAO.class).selectByObject(uid);
    }
  
    @Override
    public List<DTO> selectByString(String s) {
        return sqlSession.getMapper(AuthDAO.class).selectByString(s);
    }
    
    @Override
    public int updateByObject(Object obj) {
    	UserAuthDTO userAuth = (UserAuthDTO)obj;
        return sqlSession.getMapper(AuthDAO.class).updateByObject(userAuth);
    }
    
	@Override
	public int deleteByUserAuth(UserAuthDTO userAuthDTO) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(AuthDAO.class).deleteByUserAuth(userAuthDTO);
	}
    
    @Override
    public List<DTO> selectAll() {
        return sqlSession.getMapper(AuthDAO.class).selectAll();
    }

    @Override
    public List<DTO> selectByInt(int i) {
        return null;
    }



    @Override
    public List<DTO> selectByDTO(DTO dto) {
        return null;
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
    public int deleteByInt(int i) {
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



	
}