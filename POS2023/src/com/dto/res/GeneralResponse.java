/*
 */
package com.dto.res;

/**
 *
 * @author ASUS
 */
public class GeneralResponse {
    private boolean res;
    private String message;
    
    public GeneralResponse() {
    }

    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public GeneralResponse(boolean res, String message) {
        this.res = res;
        this.message = message;
    }

    @Override
    public String toString() {
        return "GeneralResponse{" + "res=" + res + ", message=" + message + '}';
    }
    
           
}
