package com.example.ander.shoppingcart;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ander on 7/26/2016.
 */
public class ShoppingCart extends AppCompatActivity {

    ListView mlistView;
    Context mContext;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.shopping_cart);

        mContext = this;

        Intent intent = getIntent();
        String clicked_item_name = intent.getStringExtra("name_key");
        String clicked_item_description = intent.getStringExtra("desc_key");
        String clicked_item_price = intent.getStringExtra("price_key");

        if ((clicked_item_name != null) && (clicked_item_description != null) && (clicked_item_price != null)) {
            DBHelper.getInstance(ShoppingCart.this).addItemsFromClick(clicked_item_name, clicked_item_description, clicked_item_price);
        }

        List<String> arrayList = DBHelper.getInstance(ShoppingCart.this).getAllCartItems();


        mlistView = (ListView) findViewById(R.id.cart_list);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);


        mlistView.setAdapter(arrayAdapter);
//

    }

}
