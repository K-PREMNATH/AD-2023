/*
 */
package com.db;

import com.dto.req.SystemUserReq;
import com.dto.res.GeneralResponse;

/**
 *
 * @author ASUS
 */
public interface IUser {
    
    /**
     * createNewUser
     * @param systemUserReq
     * @return GeneralResponse
     */
    public GeneralResponse createNewUser(SystemUserReq systemUserReq);
    
    /**
     * loginUser
     * @param username
     * @param password
     * @return 
     */
    public GeneralResponse loginUser(String username, String password);
}
