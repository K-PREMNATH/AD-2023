/*
 */
package com.dto;

/**
 *
 * @author ASUS
 */
public class UserDetail {

    private int userDetailId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String mobileNumber;
    private String userPassword;
    private int userType;

    public int getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(int userDetailId) {
        this.userDetailId = userDetailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserDetail{" + "userDetailId=" + userDetailId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", mobileNumber=" + mobileNumber + ", userPassword=" + userPassword + ", userType=" + userType + '}';
    }
    
    
}
