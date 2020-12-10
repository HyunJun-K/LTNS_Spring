package com.ltns.rest_area.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltns.rest_area.domain.user.AuthDAO;

@Service
public class AuthService {

    @Autowired
    AuthDAO authDAO;

    public int insertAuth(long uid) {
        return authDAO.insertByObject(uid);
    }

    public int deleteAuth(long uid) {
        return authDAO.deleteByObject(uid);
    }
}
