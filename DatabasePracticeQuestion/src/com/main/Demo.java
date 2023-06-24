/*
 */
package com.main;

import com.db.IUserDetail;
import com.db.UserDetailImpl;
import com.dto.UserDetail;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Demo {
    public static void main(String[] args) {
        
        IUserDetail userDetail = new UserDetailImpl();
        List<UserDetail> list = userDetail.getAllUserDetail();
        System.out.println(list.toString());
               
    }
}
