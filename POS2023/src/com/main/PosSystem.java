package com.main;

import com.db.impl.User;
import com.dto.req.SystemUserReq;
import com.dto.res.GeneralResponse;

/*
 */

/**
 *
 * @author ASUS
 */
public class PosSystem {
    public static void main(String[] args) {
        User user = new User();
        SystemUserReq systemUserReq = new SystemUserReq();
        systemUserReq.setUserId(0);
        systemUserReq.setFirstName("Sumudu");
        systemUserReq.setLastName("Ghomes");
        systemUserReq.setEmailAddress("sumudu@test.com");
        systemUserReq.setMobileNo("0771234567");
        systemUserReq.setUsername("sumudu");
        systemUserReq.setPassword("12345678");
        
        GeneralResponse generalResponse = user.createNewUser(systemUserReq);
        System.out.println("createNewUser-response---------->"+generalResponse.toString());
        
        
        GeneralResponse loginResponse = user.loginUser("sumudu","12345678");
        System.out.println("loginUser-response---------->"+loginResponse.toString());

       
    }
}
