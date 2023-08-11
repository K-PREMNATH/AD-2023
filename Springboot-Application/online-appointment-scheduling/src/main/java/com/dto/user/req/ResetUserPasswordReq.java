package com.dto.user.req;

public class ResetUserPasswordReq {
    private String userEmailAddress;

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    @Override
    public String toString() {
        return "ResetUserPasswordReq{" +
                "userEmailAddress='" + userEmailAddress + '\'' +
                '}';
    }
}
