package com.business;

import com.dao.UserDAO;
import com.dto.user.common.res.CommonResponse;
import com.dto.user.req.*;
import com.dto.user.res.Specialization;
import com.service.UserService;
import com.util.MessageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserManagement {
    public static final Logger logger = Logger.getLogger(UserManagement.class.getName());

    @Autowired
    UserDAO userDAO;
    public CommonResponse createUser(NewConsultantReq newUserReq) {
        CommonResponse response = null;
        try {
            logger.info("createUser-request------------>" + newUserReq.toString());
            if (newUserReq.getUserTypeId() == 1 || newUserReq.getUserTypeId() == 3) {
                /*Admin User*/
                return userDAO.createUser(newUserReq);
            } else if (newUserReq.getUserTypeId() == 2) {
                /*consultant*/
                if (newUserReq.getSpecializedId() != 0) {
                    return userDAO.createUser(newUserReq);
                } else {
                    response = new CommonResponse(null,
                            MessageConstant.SPECIALIZATION_MISSING_CODE,
                            MessageConstant.SPECIALIZATION_MISSING);
                }
            } else{
                response = new CommonResponse(null,
                        MessageConstant.COMMON_EXCEPTION_CODE,
                        MessageConstant.COMMON_EXCEPTION);
            }
        }catch (Exception exception){
            logger.info("createUser-exception------------>" + exception.toString());
            response = new CommonResponse(null,
                    MessageConstant.COMMON_EXCEPTION_CODE,
                    MessageConstant.COMMON_EXCEPTION);
        }
        return response;
    }

    public CommonResponse loginUser(UserLoginReq loginReq) {
        return userDAO.loginUser(loginReq);
    }

    public CommonResponse updateConsultantSpecial(UpdateConsultantReq updateConsultantReq) {
        return userDAO.updateConsultantSpecial(updateConsultantReq);
    }

    public List<Specialization> getSpecializations() {
        return userDAO.getSpecializations();
    }

    @Transactional
    public CommonResponse updateConsultantAvailability(UpdateConsultantAvailabilityReq updateConsultantAvailabilityReq) {
        return userDAO.updateConsultantAvailability(updateConsultantAvailabilityReq);
    }
    @Transactional
    public CommonResponse updateConsultantDeviation(UpdateConsultantDeviationReq updateConsultantDeviationReq) {
        return userDAO.updateConsultantDeviation(updateConsultantDeviationReq);
    }

    @Transactional
    public CommonResponse updateConsultantAppointment(UpdateConsultantAppointmentReq updateConsultantAppointmentReq) {
        return userDAO.updateConsultantAppointment(updateConsultantAppointmentReq);
    }

    public CommonResponse resetPassword(ResetUserPasswordReq resetPasswordReq) {
        CommonResponse commonResponse = userDAO.resetUserPassword(resetPasswordReq);
        if(commonResponse.isRes()){
            /*Write a function to send email with new password */
            return CommonResponse.generateResponse(null,commonResponse.statusCode,commonResponse.message,commonResponse.res);
        }else {
          return commonResponse;
        }
    }
}
