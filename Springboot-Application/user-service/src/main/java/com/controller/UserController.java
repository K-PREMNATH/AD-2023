package com.controller;

import com.dto.User;
import com.dto.UserLoginReq;
import com.dto.UserLoginRes;
import com.dto.UserReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

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
    public UserLoginRes userLogin(@RequestBody UserLoginReq loginReq){
        UserLoginRes userLoginRes = new UserLoginRes();
        if(loginReq.getUsername().equals("prem")){
            userLoginRes.setStatus(1);
            userLoginRes.setMessage("success");
        }else{
            userLoginRes.setStatus(10);
            userLoginRes.setMessage("failed to login");
        }
        return userLoginRes;
    }
}
