package com.dto.user.req;

public class UpdateConsultantReq {
    private int userId;
    private int specializationId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }

    @Override
    public String toString() {
        return "UpdateConsultantReq{" +
                "userId=" + userId +
                ", specializationId=" + specializationId +
                '}';
    }
}
