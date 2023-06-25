/*
 */
package com.dto.req;

/**
 *
 * @author ASUS
 */
public class CreateUpdateItem {

    private int itemId;
    private String itemName;
    private String itemDesc;
    private String itemCode;
    private int userId;
    private int categoryId;
    private double itemRate;

    public CreateUpdateItem() {
    }

    public CreateUpdateItem(int itemId, String itemName, String itemDesc, String itemCode, int userId, int categoryId, double itemRate) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemCode = itemCode;
        this.userId = userId;
        this.categoryId = categoryId;
        this.itemRate = itemRate;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getItemRate() {
        return itemRate;
    }

    public void setItemRate(double itemRate) {
        this.itemRate = itemRate;
    }

}
