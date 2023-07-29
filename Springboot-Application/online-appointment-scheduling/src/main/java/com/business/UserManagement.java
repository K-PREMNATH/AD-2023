package com.business;

import com.dao.UserDAO;
import com.dto.user.common.res.CommonResponse;
import com.dto.user.req.NewConsultantReq;
import com.service.UserService;
import com.util.MessageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
