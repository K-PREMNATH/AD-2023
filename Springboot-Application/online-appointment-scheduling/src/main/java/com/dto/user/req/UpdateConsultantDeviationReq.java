package com.dto.user.req;

public class UpdateConsultantDeviationReq {
    private String fromDateTime;
    private String toDateTime;
    private int userId;

    public UpdateConsultantDeviationReq() {
    }

    public String getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(String fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public String getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(String toDateTime) {
        this.toDateTime = toDateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UpdateConsultantDeviationReq{" +
                "fromDateTime='" + fromDateTime + '\'' +
                ", toDateTime='" + toDateTime + '\'' +
                ", userId=" + userId +
                '}';
    }
}
