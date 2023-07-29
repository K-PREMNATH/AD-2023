package com.dao;

import com.business.UserManagement;
import com.dto.user.common.res.CommonResponse;
import com.dto.user.req.NewConsultantReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Logger;

@Repository
public class UserDAO {
    public static final Logger logger = Logger.getLogger(UserDAO.class.getName());

    @Autowired
    JdbcTemplate jdbcTemplate;

    public CommonResponse createUser(NewConsultantReq newUserReq) {
        CommonResponse generalResponse = new CommonResponse();
        Connection conn = null;
        CallableStatement callableStatement;
        try {
            conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            callableStatement = conn.prepareCall(DAOConstant.INSERT_UPDATE_USER_DATAIL);
            callableStatement.setObject(1, newUserReq.getUserId(), Types.INTEGER);
            callableStatement.setObject(2, newUserReq.getFirstName(), Types.VARCHAR);
            callableStatement.setObject(3, newUserReq.getLastName(), Types.VARCHAR);
            callableStatement.setObject(4, newUserReq.getEmailAddress(), Types.VARCHAR);
            callableStatement.setObject(5, newUserReq.getMobileNumber(), Types.VARCHAR);
            callableStatement.setObject(6, newUserReq.getSuPassword(), Types.VARCHAR);
            callableStatement.setObject(7, newUserReq.getUserTypeId(), Types.INTEGER);
            callableStatement.setObject(8, newUserReq.getSpecializedId(), Types.INTEGER);
            callableStatement.registerOutParameter(9, Types.BOOLEAN);
            callableStatement.registerOutParameter(10, Types.INTEGER);
            callableStatement.registerOutParameter(11, Types.VARCHAR);

            callableStatement.executeUpdate();

            generalResponse.setRes((boolean) callableStatement.getObject(9));
            generalResponse.setStatusCode((Integer) callableStatement.getObject(10));
            generalResponse.setMessage((String) callableStatement.getObject(11));

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
