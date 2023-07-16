package com.controller;

import com.business.UserManagement;
import com.dto.res.GeneralResponse;
import com.dto.res.User;
import com.dto.req.UserLoginReq;
import com.dto.res.UserLoginRes;
import com.dto.req.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserManagement userManagement;

    @PostMapping("/print/text")
    public void printText(){
        System.out.println("hi");
    }

    @PostMapping("/get/user/payload/by/request")
    public void getUserPayloadRequest(@RequestBody UserReq userReq){
        System.out.println(userReq.toString());
    }

    @PostMapping("/return/single/value")
    public String returnSingleValueFromAPI(){
       return "Hello";
    }

    @PostMapping("/return/object/value")
    public User returnObjectValueFromAPI(){
        User user = new User();
        user.setFirstName("Kathirkamanathan");
        user.setLastName("Premnath");
        user.setAge(32);
        user.setGender((short) 1);
        return user;
    }

    @PostMapping("/user/login")
    public GeneralResponse userLogin(@RequestBody UserLoginReq loginReq){
        return userManagement.userLogin(loginReq);
    }
}
