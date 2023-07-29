package com.dto.user.common.res;

public class CommonResponse {
    public Object value;
    public int statusCode;
    public String message;

    public CommonResponse() {
    }

    public CommonResponse(Object value, int statusCode, String message) {
        this.value = value;
        this.statusCode = statusCode;
        this.message = message;
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
}
