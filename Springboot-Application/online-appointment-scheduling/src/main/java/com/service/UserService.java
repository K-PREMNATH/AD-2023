package com.service;

import com.business.UserManagement;
import com.dto.user.common.res.CommonResponse;
import com.dto.user.req.*;
import com.dto.user.res.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/oas")
public class UserService {
    public static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    UserManagement userManagement;


    @PostMapping("/update/user")
    public CommonResponse createUser(@RequestBody NewConsultantReq newUserReq){
        CommonResponse commonResponse = userManagement.createUser(newUserReq);
        return CommonResponse.generateResponse(
                commonResponse.value,
                commonResponse.statusCode,
                commonResponse.message);
    }

    @PostMapping("/login/user")
    public CommonResponse loginUser(@RequestBody UserLoginReq loginReq){
        CommonResponse commonResponse = userManagement.loginUser(loginReq);
        return CommonResponse.generateResponse(
                commonResponse.value,
                commonResponse.statusCode,
                commonResponse.message);
    }

    @PostMapping("/update/specialization")
    public CommonResponse updateConsultantSpecial(@RequestBody UpdateConsultantReq updateConsultantReq){
        CommonResponse commonResponse = userManagement.updateConsultantSpecial(updateConsultantReq);
        return CommonResponse.generateResponse(
                commonResponse.value,
                commonResponse.statusCode,
                commonResponse.message,
                commonResponse.res);
    }

    @PostMapping("/get/specializations")
    public CommonResponse getSpecializations(){
        List<Specialization> list  = userManagement.getSpecializations();
        return CommonResponse.generateResponse(
                list,
                0,
                "success",
                true);
    }

    @PostMapping("/update/consultant/availability")
    public CommonResponse updateConsultantAvailability(@RequestBody UpdateConsultantAvailabilityReq updateConsultantAvailabilityReq){
        return userManagement.updateConsultantAvailability(updateConsultantAvailabilityReq);
    }

    @PostMapping("/update/consultant/deviation")
    public CommonResponse updateConsultantDeviation(@RequestBody UpdateConsultantDeviationReq updateConsultantDeviationReq){
        return userManagement.updateConsultantDeviation(updateConsultantDeviationReq);
    }

}
