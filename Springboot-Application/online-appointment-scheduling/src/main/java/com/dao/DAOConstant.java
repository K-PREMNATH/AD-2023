package com.dao;

public class DAOConstant {
    public static final String INSERT_UPDATE_USER_DATAIL = "{call insert_update_user_detail(?,?,?,?,?,?,?,?,?,?,?)}";
    public static final String USER_LOGIN_DETAIL = "{call user_login_detail(?,?,?,?,?,?,?,?)}";
    public static final String UPDATE_CONSULTANT_SPECIALIZATION = "{call update_consultant_specialization(?,?,?,?,?)}";
    public static final String GET_SPECIALIZATIONS = "select SpecializationId,concat(Country,' - ',JobType) as Ctypes from specialization";

    public static final String UPDATE_CONSULTANT_AVAILABILITY = "{call update_consultant_availability(?,?,?,?,?,?,?)}";

    public static final String UPDATE_CONSULTANT_DEVIATION = "{call update_consultant_deviation(?,?,?,?,?,?)}";

}


