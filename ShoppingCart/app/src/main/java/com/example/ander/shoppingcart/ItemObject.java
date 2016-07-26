package com.example.ander.shoppingcart;

import android.content.ClipData;
import android.content.Intent;

/**
 * Created by ander on 7/25/2016.
 */
public class ItemObject {

    private String mName;
    private String mDescription;
    private float mPrice;

    public ItemObject(String name, String description, float price) {
        mName = name;
        mDescription = description;
        mPrice = price;
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
