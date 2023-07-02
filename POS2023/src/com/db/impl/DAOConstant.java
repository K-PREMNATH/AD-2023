/*
 */
package com.db.impl;

/**
 *
 * @author ASUS
 */
public class DAOConstant {
    public static String INSERT_UPDATE_ITEM_DATAIL = "{call insert_update_item_detail(?,?,?,?,?,?,?,?,?)}";
    
    public static String INSERT_UPDATE_USER_DATAIL = "{call insert_update_user_detail(?,?,?,?,?,?,?,?,?)}";
    
    public static String USER_LOGIN = "{call user_login(?,?,?,?)}";
}
