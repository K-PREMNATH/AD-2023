package com.business;

import com.dao.UserDAO;
import com.dto.req.UserLoginReq;
import com.dto.res.GeneralResponse;
import com.dto.res.UserLoginRes;
import com.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagement {

    @Autowired
    UserDAO userDAO;

    public GeneralResponse userLogin(UserLoginReq loginReq){
        loginReq.setPassword(EncryptionUtil.encryptText(loginReq.getPassword()));
        return userDAO.loginUser(loginReq.getUsername(),loginReq.getPassword());
    }
}
