package com.dao;

import com.dto.res.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

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
        }finally {
            try {
                DataSourceUtils.doReleaseConnection(conn,jdbcTemplate.getDataSource());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return generalResponse;
    }
}
