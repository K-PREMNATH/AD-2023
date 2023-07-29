package com.dto.user.req;

public class NewConsultantReq extends NewUserReq{
    private int specializedId;

    public NewConsultantReq() {
    }

    public int getSpecializedId() {
        return specializedId;
    }

    public void setSpecializedId(int specializedId) {
        this.specializedId = specializedId;
    }

    @Override
    public String toString() {
        return "NewConsultantReq{" +
                "NewUserReq=" + super.toString() +
                ", specializedId=" + specializedId +
                '}';
    }
}
