package com.dto.user.common.res;

public class CommonResponse {
    public Object value;
    public boolean res;
    public int statusCode;
    public String message;

    public CommonResponse() {
    }

    public CommonResponse(Object value, boolean res, int statusCode, String message) {
        this.value = value;
        this.res = res;
        this.statusCode = statusCode;
        this.message = message;
    }

    public CommonResponse(Object value, int statusCode, String message) {
        this.value = value;
        this.statusCode = statusCode;
        this.message = message;
    }

    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static CommonResponse generateResponse(Object value, int statusCode, String message){
        return new CommonResponse(value,statusCode,message);
    }
    public static CommonResponse generateResponse(Object value, int statusCode, String message,boolean res){
        return new CommonResponse(value,res,statusCode,message);
    }
}
