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

    @Override // 등급 insert
    public int insertByObject(Object obj) {
        long uid = (long) obj;
        return sqlSession.getMapper(AuthDAO.class).insertByObject(uid);
    }

    @Override // 회원 탈퇴시 등급 제거 또는 uid 값으로 등급 제거 (foreign key => uid)
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
}
