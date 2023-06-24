/*
 */
package com.db;

import com.dto.UserDetail;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IUserDetail {
    /**
     * getAllUserDetail
     * @return 
     */
    public List<UserDetail> getAllUserDetail();
    
    /**
     * getUserDetailByEmailId
     * @param emailAddress
     * @return 
     */
    public UserDetail getUserDetailByEmailId(String emailAddress);
    
}
