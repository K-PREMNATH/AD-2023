package com.dto.user.req;

public class UpdateConsultantAppointmentReq {
    private int appointmentId;
    private String appointmentDateTime;
    private int consultantId;
    private int userId;

    public UpdateConsultantAppointmentReq() {
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(String appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public int getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(int consultantId) {
        this.consultantId = consultantId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UpdateConsultantAppointmentReq{" +
                "appointmentId=" + appointmentId +
                ", appointmentDateTime='" + appointmentDateTime + '\'' +
                ", consultantId=" + consultantId +
                ", userId=" + userId +
                '}';
    }
}
