package com.dto.user.req;

public class UpdateConsultantAvailabilityReq {
    private int dayNumber;
    private String fromTime;
    private String toTime;
    private int userId;

    public UpdateConsultantAvailabilityReq() {
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UpdateConsultantAvailabilityReq{" +
                "dayNumber=" + dayNumber +
                ", fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                ", userId=" + userId +
                '}';
    }
}
