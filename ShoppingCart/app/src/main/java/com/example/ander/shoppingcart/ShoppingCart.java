package com.example.ander.shoppingcart;

import android.content.Context;

/**
 * Created by ander on 7/26/2016.
 */
public class ShoppingCart {

    private ShoppingCart shoppingCartInstance;

    public ShoppingCart getInstance(){
        if(shoppingCartInstance == null){
            shoppingCartInstance = new ShoppingCart();
        }
        return shoppingCartInstance;
    }

    public void addItemToCart(Context context, String name, String description, float price){
        DBHelper db = DBHelper.getInstance(context);

        //find matching items
//        db.find
    }

}
