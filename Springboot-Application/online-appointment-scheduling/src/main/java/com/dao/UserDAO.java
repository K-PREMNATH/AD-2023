package com.dao;

import com.business.UserManagement;
import com.dto.user.common.res.CommonResponse;
import com.dto.user.req.*;
import com.dto.user.res.Specialization;
import com.dto.user.res.UserLoginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public CommonResponse loginUser(UserLoginReq loginReq) {
        CommonResponse generalResponse = new CommonResponse();
        Connection conn = null;
        CallableStatement callableStatement;
        try {
            logger.info("loginUser------------->"+loginReq.toString());
            conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            callableStatement = conn.prepareCall(DAOConstant.USER_LOGIN_DETAIL);
            callableStatement.setObject(1, loginReq.getEmailAddress(), Types.VARCHAR);
            callableStatement.setObject(2, loginReq.getUserPassword(), Types.VARCHAR);
            callableStatement.registerOutParameter(3, Types.INTEGER);
            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.registerOutParameter(5, Types.VARCHAR);
            callableStatement.registerOutParameter(6, Types.BOOLEAN);
            callableStatement.registerOutParameter(7, Types.INTEGER);
            callableStatement.registerOutParameter(8, Types.VARCHAR);

            callableStatement.executeUpdate();
            UserLoginRes userLoginRes = new UserLoginRes(
                    (Integer) callableStatement.getObject(3),
                    (Integer) callableStatement.getObject(4),
                    (String) callableStatement.getObject(5)
            );
            generalResponse.setValue(userLoginRes);

            generalResponse.setRes((boolean) callableStatement.getObject(6));
            generalResponse.setStatusCode((Integer) callableStatement.getObject(7));
            generalResponse.setMessage((String) callableStatement.getObject(8));

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

    public CommonResponse updateConsultantSpecial(UpdateConsultantReq updateConsultantReq) {
        CommonResponse generalResponse = new CommonResponse();
        Connection conn = null;
        CallableStatement callableStatement;
        try {
            logger.info("updateConsultantSpecial------------->"+updateConsultantReq.toString());
            conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            callableStatement = conn.prepareCall(DAOConstant.UPDATE_CONSULTANT_SPECIALIZATION);
            callableStatement.setObject(1, updateConsultantReq.getUserId(), Types.INTEGER);
            callableStatement.setObject(2, updateConsultantReq.getSpecializationId(), Types.INTEGER);
            callableStatement.registerOutParameter(3, Types.BOOLEAN);
            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.registerOutParameter(5, Types.VARCHAR);

            callableStatement.executeUpdate();

            generalResponse.setRes((boolean) callableStatement.getObject(3));
            generalResponse.setStatusCode((Integer) callableStatement.getObject(4));
            generalResponse.setMessage((String) callableStatement.getObject(5));

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

    public List<Specialization> getSpecializations() {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Specialization> list = new ArrayList<>();
        try {
            conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = conn.createStatement();
            resultSet = statement.executeQuery(DAOConstant.GET_SPECIALIZATIONS);
            while (resultSet.next()){
                Specialization specialization = new Specialization();
                specialization.setSpecializationId(resultSet.getInt(1));
                specialization.setSpecializationName(resultSet.getString(2));

                list.add(specialization);
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

    public CommonResponse updateConsultantAvailability(UpdateConsultantAvailabilityReq updateConsultantAvailabilityReq) {
        CommonResponse generalResponse = new CommonResponse();
        Connection conn = null;
        CallableStatement callableStatement;
        try {
            logger.info("updateConsultantAvailability------------->"+updateConsultantAvailabilityReq.toString());
            conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            callableStatement = conn.prepareCall(DAOConstant.UPDATE_CONSULTANT_AVAILABILITY);
            callableStatement.setObject(1, updateConsultantAvailabilityReq.getDayNumber(), Types.INTEGER);
            callableStatement.setObject(2, updateConsultantAvailabilityReq.getFromTime(), Types.VARCHAR);
            callableStatement.setObject(3, updateConsultantAvailabilityReq.getToTime(), Types.VARCHAR);
            callableStatement.setObject(4, updateConsultantAvailabilityReq.getUserId(), Types.INTEGER);
            callableStatement.registerOutParameter(5, Types.BOOLEAN);
            callableStatement.registerOutParameter(6, Types.INTEGER);
            callableStatement.registerOutParameter(7, Types.VARCHAR);

            callableStatement.executeUpdate();

            generalResponse.setRes((boolean) callableStatement.getObject(5));
            generalResponse.setStatusCode((Integer) callableStatement.getObject(6));
            generalResponse.setMessage((String) callableStatement.getObject(7));

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

    public CommonResponse updateConsultantDeviation(UpdateConsultantDeviationReq updateConsultantDeviationReq) {
        CommonResponse generalResponse = new CommonResponse();
        Connection conn = null;
        CallableStatement callableStatement;
        try {
            logger.info("updateConsultantDeviation------------->"+updateConsultantDeviationReq.toString());
            conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            callableStatement = conn.prepareCall(DAOConstant.UPDATE_CONSULTANT_DEVIATION);
            callableStatement.setObject(1, updateConsultantDeviationReq.getFromDateTime(), Types.VARCHAR);
            callableStatement.setObject(2, updateConsultantDeviationReq.getToDateTime(), Types.VARCHAR);
            callableStatement.setObject(3, updateConsultantDeviationReq.getUserId(), Types.INTEGER);
            callableStatement.registerOutParameter(4, Types.BOOLEAN);
            callableStatement.registerOutParameter(5, Types.INTEGER);
            callableStatement.registerOutParameter(6, Types.VARCHAR);

            callableStatement.executeUpdate();

            generalResponse.setRes((boolean) callableStatement.getObject(4));
            generalResponse.setStatusCode((Integer) callableStatement.getObject(5));
            generalResponse.setMessage((String) callableStatement.getObject(6));

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

    public CommonResponse updateConsultantAppointment(UpdateConsultantAppointmentReq updateConsultantAppointmentReq) {
        CommonResponse generalResponse = new CommonResponse();
        Connection conn = null;
        CallableStatement callableStatement;
        try {
            logger.info("updateConsultantAppointment------------->"+updateConsultantAppointmentReq.toString());
            conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            callableStatement = conn.prepareCall(DAOConstant.INSERT_CONSULTANT_APPOINTMENT);
            callableStatement.setObject(1, updateConsultantAppointmentReq.getAppointmentId(), Types.INTEGER);
            callableStatement.setObject(2, updateConsultantAppointmentReq.getAppointmentDateTime(), Types.VARCHAR);
            callableStatement.setObject(3, updateConsultantAppointmentReq.getConsultantId(), Types.INTEGER);
            callableStatement.setObject(4, updateConsultantAppointmentReq.getUserId(), Types.INTEGER);
            callableStatement.registerOutParameter(5, Types.BOOLEAN);
            callableStatement.registerOutParameter(6, Types.INTEGER);
            callableStatement.registerOutParameter(7, Types.VARCHAR);

            callableStatement.executeUpdate();

            generalResponse.setRes((boolean) callableStatement.getObject(5));
            generalResponse.setStatusCode((Integer) callableStatement.getObject(6));
            generalResponse.setMessage((String) callableStatement.getObject(7));

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

    public CommonResponse resetUserPassword(ResetUserPasswordReq resetUserPasswordReq) {
        CommonResponse generalResponse = new CommonResponse();
        Connection conn = null;
        CallableStatement callableStatement;
        try {
            logger.info("resetUserPassword------------->"+resetUserPasswordReq.toString());
            conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            callableStatement = conn.prepareCall(DAOConstant.RESET_USER_PASSWORD);
            callableStatement.setObject(1, resetUserPasswordReq.getUserEmailAddress(), Types.VARCHAR);
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.registerOutParameter(3, Types.BOOLEAN);
            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.registerOutParameter(5, Types.VARCHAR);

            callableStatement.executeUpdate();
            Map map = new HashMap();
            map.put("newPassword",(String) callableStatement.getObject(2));

            generalResponse.setValue(map);
            generalResponse.setRes((boolean) callableStatement.getObject(3));
            generalResponse.setStatusCode((Integer) callableStatement.getObject(4));
            generalResponse.setMessage((String) callableStatement.getObject(5));

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
