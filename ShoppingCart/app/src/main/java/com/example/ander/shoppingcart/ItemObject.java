package com.example.ander.shoppingcart;

import android.content.ClipData;
import android.content.Intent;

/**
 * Created by ander on 7/25/2016.
 */
public class ItemObject {

    private String mName;
    private String mDescription;
    private String mArea;
    private float mPrice;

    public ItemObject(String name, String description, float price, String area) {
        mName = name;
        mDescription = description;
        mPrice = price;
        mArea = area;
    }

    public ItemObject(String name, String description, float price) {
        mName = name;
        mDescription = description;
        mPrice = price;
    }

    public String getmArea() {
        return mArea;
    }

    public void setmArea(String mArea) {
        this.mArea = mArea;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String name) {
        this.mName = name;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String description) {
        this.mDescription = description;
    }

    public float getmPrice() {
        return mPrice;
    }

    public void setmPrice(float price) {
        this.mPrice = price;
    }
}
