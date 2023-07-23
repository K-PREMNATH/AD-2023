package com.dto.res;


public class GeneralResponse {

    private Object value;
    private boolean res;
    private String message;

    public GeneralResponse() {
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
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

    public GeneralResponse(Object value, boolean res, String message) {
        this.value = value;
        this.res = res;
        this.message = message;
    }

    @Override
    public String toString() {
        return "GeneralResponse{" + "res=" + res + ", message=" + message + '}';
    }


}
