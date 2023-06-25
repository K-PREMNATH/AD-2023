/*
 */
package com.db;

import com.dto.req.CreateUpdateItem;
import com.dto.res.GeneralResponse;

/**
 *
 * @author ASUS
 */
public interface IItem {
    /**
     * inserUpdateItem
     * @param createUpdateItem
     * @return 
     */
    public GeneralResponse inserUpdateItem(CreateUpdateItem createUpdateItem);
}
