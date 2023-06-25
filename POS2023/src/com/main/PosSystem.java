package com.main;

import com.db.IItem;
import com.db.impl.Item;
import com.dto.req.CreateUpdateItem;
import com.dto.res.GeneralResponse;

/*
 */

/**
 *
 * @author ASUS
 */
public class PosSystem {
    public static void main(String[] args) {
        System.out.println("Hello");
        IItem iItem = new Item();
        CreateUpdateItem createItem = new CreateUpdateItem(0,"Orange Soda","","ORGSDAD",1,1,20.56);
        GeneralResponse response = iItem.inserUpdateItem(createItem);
        System.out.println(response.toString());
    }
}
