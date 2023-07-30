package com.dto.user.req;

public class UserLoginReq {
    private String emailAddress;
    private String userPassword;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "UserLoginReq{" +
                "emailAddress='" + emailAddress + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
