package com.dto.user.res;

public class UserLoginRes {
    private int userTypeId;
    private int userId;
    private String lastName;

    public UserLoginRes() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserLoginRes(int userTypeId, int userId) {
        this.userTypeId = userTypeId;
        this.userId = userId;
    }

    public UserLoginRes(int userTypeId, int userId, String lastName) {
        this.userTypeId = userTypeId;
        this.userId = userId;
        this.lastName = lastName;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
