package com.controller;

import com.business.UserManagement;
import com.dto.req.CreateNewUserReq;
import com.dto.req.GetUserDetailReq;
import com.dto.req.UserLoginReq;
import com.dto.res.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserManagement userManagement;

    @PostMapping("/user/login")
    public GeneralResponse userLogin(@RequestBody UserLoginReq loginReq){
        return userManagement.userLogin(loginReq);
    }

    @PostMapping("/user/signup")
    public GeneralResponse userSignUp(@RequestBody CreateNewUserReq createNewUserReq){
        return userManagement.userSignUp(createNewUserReq);
    }

    @PostMapping("/get/users/list")
    public GeneralResponse getUserDetailList(){
        return  new GeneralResponse(userManagement.getUserDetailList(),true,"success");
    }
}
