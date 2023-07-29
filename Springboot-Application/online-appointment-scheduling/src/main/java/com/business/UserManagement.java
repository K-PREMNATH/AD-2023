package com.business;

import com.dto.user.common.res.CommonResponse;
import com.dto.user.req.NewConsultantReq;
import com.service.UserService;
import com.util.MessageConstant;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserManagement {
    public static final Logger logger = Logger.getLogger(UserManagement.class.getName());
    public CommonResponse createUser(NewConsultantReq newUserReq) {
        CommonResponse response = null;
        try {
            logger.info("createUser-request------------>" + newUserReq.toString());
            if (newUserReq.getUserTypeId() == 1) {
                /*Admin User*/
            } else if (newUserReq.getUserTypeId() == 2) {
                /*consultant*/
                if (newUserReq.getSpecializedId() != 0) {

                } else {
                    response = new CommonResponse(null,
                            MessageConstant.SPECIALIZATION_MISSING_CODE,
                            MessageConstant.SPECIALIZATION_MISSING);
                }
            } else if (newUserReq.getUserTypeId() == 3) {
                /*jobseeker*/
            }
        }catch (Exception exception){
            logger.info("createUser-exception------------>" + exception.toString());
            response = new CommonResponse(null,
                    MessageConstant.COMMON_EXCEPTION_CODE,
                    MessageConstant.COMMON_EXCEPTION);
        }
        return response;
    }
}
