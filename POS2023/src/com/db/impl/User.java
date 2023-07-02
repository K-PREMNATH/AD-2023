/*
 */
package com.db.impl;

import com.db.IUser;
import com.dto.req.SystemUserReq;
import com.dto.res.GeneralResponse;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import util.EncryptionUtil;

/**
 *
 * @author ASUS
 */
public class User extends DBConnection implements IUser{

    @Override
    public GeneralResponse createNewUser(SystemUserReq systemUserReq) {
        GeneralResponse generalResponse = new GeneralResponse();
        Connection conn;
        CallableStatement callableStatement;
        try {
            systemUserReq.setPassword(EncryptionUtil.encryptText(systemUserReq.getPassword()));
            System.out.println("createNewUser-request--------------->"+systemUserReq.toString());
            conn = this.dbConnect();
            callableStatement = conn.prepareCall(DAOConstant.INSERT_UPDATE_USER_DATAIL);
            callableStatement.setObject(1, systemUserReq.getUserId(), Types.INTEGER);
            callableStatement.setObject(2, systemUserReq.getFirstName(), Types.VARCHAR);
            callableStatement.setObject(3, systemUserReq.getLastName(), Types.VARCHAR);
            callableStatement.setObject(4, systemUserReq.getEmailAddress(), Types.VARCHAR);
            callableStatement.setObject(5, systemUserReq.getMobileNo(), Types.VARCHAR);
            callableStatement.setObject(6, systemUserReq.getUsername(), Types.VARCHAR);
            callableStatement.setObject(7, systemUserReq.getPassword(), Types.VARCHAR);
            callableStatement.registerOutParameter(8, Types.BOOLEAN);
            callableStatement.registerOutParameter(9, Types.VARCHAR);
           
            callableStatement.executeUpdate();
            
            generalResponse.setRes((boolean) callableStatement.getObject(8));
            generalResponse.setMessage((String) callableStatement.getObject(9));
            
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return generalResponse;
    }

    @Override
    public GeneralResponse loginUser(String username, String password) {
        GeneralResponse generalResponse = new GeneralResponse();
        Connection conn;
        CallableStatement callableStatement;
        try {
            password = EncryptionUtil.encryptText(password);
            System.out.println(password);
            conn = this.dbConnect();
            callableStatement = conn.prepareCall(DAOConstant.USER_LOGIN);
            callableStatement.setObject(1, username, Types.VARCHAR);
            callableStatement.setObject(2, password, Types.VARCHAR);
            callableStatement.registerOutParameter(3, Types.BOOLEAN);
            callableStatement.registerOutParameter(4, Types.VARCHAR);
           
            callableStatement.executeUpdate();
            
            generalResponse.setRes((boolean) callableStatement.getObject(3));
            generalResponse.setMessage((String) callableStatement.getObject(4));
            
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return generalResponse;
    }
    
}
