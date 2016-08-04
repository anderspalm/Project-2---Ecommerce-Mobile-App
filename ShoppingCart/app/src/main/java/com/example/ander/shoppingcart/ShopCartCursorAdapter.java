package com.example.ander.shoppingcart;

import android.content.ClipData;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ander on 7/28/2016.
 */
public class ShopCartCursorAdapter extends CursorAdapter {

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.shopping_cart, parent, false);
        return view;
    }

    public ShopCartCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        while (cursor.moveToNext()) {

            TextView textName = (TextView) view.findViewById(R.id.cart_item_name);
            textName.setText(cursor.getString(cursor.getColumnIndex(DBHelper.ITEM_NAME)));

            TextView textDesc = (TextView) view.findViewById(R.id.cart_item_description);
            textDesc.setText(cursor.getString(cursor.getColumnIndex(DBHelper.ITEM_DESCRIPTION)));

            TextView textPrice = (TextView) view.findViewById(R.id.cart_item_price);
            textPrice.setText(cursor.getString(cursor.getColumnIndex(DBHelper.CART_PRICE)));

        }
    }

}

