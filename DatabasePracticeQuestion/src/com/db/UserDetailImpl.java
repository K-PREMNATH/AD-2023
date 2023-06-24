/*
 */
package com.db;

import com.dto.UserDetail;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class UserDetailImpl extends DBConnection implements IUserDetail{

    @Override
    public List<UserDetail> getAllUserDetail() {
        Connection connection = null;
        Statement statement = null;
        List<UserDetail> list = null;
        try{
            String query = "SELECT UserDetailId,FirstName,LastName,EmailAddress,UserPassword,MobileNumber,UserType FROM userdetail;";
            connection = this.dbConnect();
            statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery(query);
            if(resultSet != null){
                list = new ArrayList<>();
                while(resultSet.next()){
                    UserDetail detail = new UserDetail();
                    detail.setUserDetailId(resultSet.getInt(1));
                    detail.setFirstName(resultSet.getString(2));
                    detail.setLastName(resultSet.getString(3));
                    detail.setEmailAddress(resultSet.getString("EmailAddress"));
                    detail.setUserPassword(resultSet.getString("UserPassword"));
                    detail.setMobileNumber(resultSet.getString("MobileNumber"));
                    detail.setUserType(resultSet.getInt("UserType"));
                    
                    list.add(detail);
                }
            }
        }catch(SQLException exception){
            System.out.println("SQLException---------------->"+exception.toString());
        }catch(Exception exception){
            System.out.println("Exception---------------->"+exception.toString());
        }finally{
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("SQLException---------------->"+ex.toString());
                }
            }
        }
        return list;
    }

    @Override
    public UserDetail getUserDetailByEmailId(String emailAddress) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
