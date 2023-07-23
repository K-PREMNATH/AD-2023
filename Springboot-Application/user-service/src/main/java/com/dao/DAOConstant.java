package com.dao;

public class DAOConstant {
    public static final String INSERT_UPDATE_USER_DATAIL = "{call insert_update_user_detail(?,?,?,?,?,?,?,?,?)}";
    public static final String USER_LOGIN_DETAIL = "{call user_login_detail(?,?,?,?,?,?)}";

    public static final String GET_USER_DETAIL_LIST = "{call get_users_list()}";
}
