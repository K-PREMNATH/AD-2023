package com.dao;

import com.dto.req.CreateNewUserReq;
import com.dto.req.GetUserDetailReq;
import com.dto.res.GeneralResponse;
import com.dto.res.GetUserDetailRes;
import com.dto.res.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {


    @Autowired
    JdbcTemplate jdbcTemplate;

    public GeneralResponse loginUser(String username, String password) {
        GeneralResponse generalResponse = new GeneralResponse();
        Connection conn = null;
        CallableStatement callableStatement;
        try {
            conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            callableStatement = conn.prepareCall(DAOConstant.USER_LOGIN_DETAIL);
            callableStatement.setObject(1, username, Types.VARCHAR);
            callableStatement.setObject(2, password, Types.VARCHAR);
            callableStatement.registerOutParameter(3, Types.VARCHAR);
            callableStatement.registerOutParameter(4, Types.BOOLEAN);
            callableStatement.registerOutParameter(5, Types.VARCHAR);
            callableStatement.executeUpdate();
            generalResponse.setRes((boolean) callableStatement.getObject(4));
            generalResponse.setMessage((String) callableStatement.getObject(5));
            if(generalResponse.isRes()){
                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setLastName((String) callableStatement.getObject(3));

                generalResponse.setValue(loginResponse);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            try {
                DataSourceUtils.doReleaseConnection(conn,jdbcTemplate.getDataSource());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return generalResponse;
    }


    public GeneralResponse userSignUp(CreateNewUserReq createNewUserReq) {
        GeneralResponse generalResponse = new GeneralResponse();
        Connection conn = null;
        CallableStatement callableStatement;
        try {
            conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            callableStatement = conn.prepareCall(DAOConstant.INSERT_UPDATE_USER_DATAIL);
            callableStatement.setObject(1, createNewUserReq.getUserId(), Types.INTEGER);
            callableStatement.setObject(2, createNewUserReq.getFirstName(), Types.VARCHAR);
            callableStatement.setObject(3, createNewUserReq.getLastName(), Types.VARCHAR);
            callableStatement.setObject(4, createNewUserReq.getEmailAddress(), Types.VARCHAR);
            callableStatement.setObject(5, createNewUserReq.getMobileNo(), Types.VARCHAR);
            callableStatement.setObject(6, createNewUserReq.getUsername(), Types.VARCHAR);
            callableStatement.setObject(7, createNewUserReq.getPassword(), Types.VARCHAR);
            callableStatement.registerOutParameter(8, Types.BOOLEAN);
            callableStatement.registerOutParameter(9, Types.VARCHAR);

            callableStatement.executeUpdate();

            generalResponse.setRes((boolean) callableStatement.getObject(8));
            generalResponse.setMessage((String) callableStatement.getObject(9));

        } catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            try {
                DataSourceUtils.doReleaseConnection(conn,jdbcTemplate.getDataSource());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return generalResponse;
    }

    public List<GetUserDetailRes> getUserDetailList(GetUserDetailReq getUserDetailReq) {
        Connection conn = null;
        CallableStatement callableStatement;
        ResultSet resultSet = null;
        List<GetUserDetailRes> list = new ArrayList<>();
        try {
            conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            callableStatement = conn.prepareCall(DAOConstant.GET_USER_DETAIL_LIST);
            callableStatement.setObject(1, getUserDetailReq.getSearchKey(), Types.VARCHAR);
            resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                GetUserDetailRes getUserRes = new GetUserDetailRes();
                getUserRes.setUserId(resultSet.getInt("USER_ID"));
                getUserRes.setFirstName(resultSet.getString("FIRST_NAME"));
                getUserRes.setLastName(resultSet.getString("LAST_NAME"));
                getUserRes.setEmailAddress(resultSet.getString("EMAIL_ID"));
                getUserRes.setMobileNumber(resultSet.getString("MOBILE_NUMBER"));
                list.add(getUserRes);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            try {
                DataSourceUtils.doReleaseConnection(conn,jdbcTemplate.getDataSource());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
