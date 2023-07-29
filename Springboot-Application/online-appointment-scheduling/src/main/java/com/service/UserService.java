package com.service;

import com.business.UserManagement;
import com.dto.user.common.res.CommonResponse;
import com.dto.user.req.NewConsultantReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/oas")
public class UserService {
    public static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    UserManagement userManagement;


    @PostMapping("/create/user")
    public CommonResponse createUser(@RequestBody NewConsultantReq newUserReq){
        CommonResponse commonResponse = userManagement.createUser(newUserReq);
        return CommonResponse.generateResponse(
                commonResponse.value,
                commonResponse.statusCode,
                commonResponse.message);
    }
}
