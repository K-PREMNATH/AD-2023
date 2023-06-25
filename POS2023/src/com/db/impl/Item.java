/*
 */
package com.db.impl;

import com.db.IItem;
import com.dto.req.CreateUpdateItem;
import com.dto.res.GeneralResponse;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author ASUS
 */
public class Item extends DBConnection implements IItem {

    @Override
    public GeneralResponse inserUpdateItem(CreateUpdateItem createUpdateItem) {
        GeneralResponse generalResponse = new GeneralResponse();
        Connection conn;
        CallableStatement callableStatement;
        //ResultSet resultSet;
        try {
            conn = this.dbConnect();
            callableStatement = conn.prepareCall(DAOConstant.INSERT_UPDATE_ITEM_DATAIL);
            callableStatement.setObject(1, createUpdateItem.getItemId(), Types.INTEGER);
            callableStatement.setObject(2, createUpdateItem.getItemName(), Types.VARCHAR);
            callableStatement.setObject(3, createUpdateItem.getItemDesc(), Types.VARCHAR);
            callableStatement.setObject(4, createUpdateItem.getItemCode(), Types.VARCHAR);
            callableStatement.setObject(5, createUpdateItem.getUserId(), Types.INTEGER);
            callableStatement.setObject(6, createUpdateItem.getCategoryId(), Types.INTEGER);
            callableStatement.setObject(7, createUpdateItem.getItemRate(), Types.DOUBLE);
            callableStatement.registerOutParameter(8, Types.BOOLEAN);
            callableStatement.registerOutParameter(9, Types.VARCHAR);
           
            callableStatement.executeUpdate();
            
            generalResponse.setRes((boolean) callableStatement.getObject(8));
            generalResponse.setMessage((String) callableStatement.getObject(9));
            
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return generalResponse;
    }

}
