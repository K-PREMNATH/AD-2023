package com.business;

import com.dao.UserDAO;
import com.dto.req.CreateNewUserReq;
import com.dto.req.GetUserDetailReq;
import com.dto.req.UserLoginReq;
import com.dto.res.GeneralResponse;
import com.dto.res.GetUserDetailRes;
import com.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserManagement {

    @Autowired
    UserDAO userDAO;

    public GeneralResponse userLogin(UserLoginReq loginReq){
        loginReq.setPassword(EncryptionUtil.encryptText(loginReq.getPassword()));
        return userDAO.loginUser(loginReq.getUsername(),loginReq.getPassword());
    }

    @Transactional
    public GeneralResponse userSignUp(CreateNewUserReq createNewUserReq) {
        createNewUserReq.setPassword(EncryptionUtil.encryptText(createNewUserReq.getPassword()));
        return userDAO.userSignUp(createNewUserReq);
    }

    public List<GetUserDetailRes> getUserDetailList(GetUserDetailReq getUserDetailReq) {
        return userDAO.getUserDetailList(getUserDetailReq);
    }
}
