package com.example.ander.shoppingcart;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ander on 7/26/2016.
 */
public class ShoppingCart extends AppCompatActivity {

    ListView mlistView;
    Context mContext;
    AsyncTask<Cursor, Integer, Cursor> mRepopulationtask;
    AsyncTask<Void,Void,Void> mAddingTask;
//    public Button mItemPurchaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.shopping_cart);

//        if ((clicked_item_name != null) && (clicked_item_description != null) && (clicked_item_price != null)) {
//        DBHelper.getInstance(ShoppingCart.this).addItemsFromClick(clicked_item_name, clicked_item_description, clicked_item_price);}
//        List<String> arrayList = DBHelper.getInstance(ShoppingCart.this).getAllCartItems();
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
//        mlistView.setAdapter(arrayAdapter);

        mContext = this;

        mlistView = (ListView) findViewById(R.id.cart_list);

        final Cursor cursor = DBHelper.getInstance(ShoppingCart.this).getAllCartItems();

        CursorAdapter cursorAdapter = new CursorAdapter(ShoppingCart.this, cursor, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.shopping_cart_items, parent, false);
            }

            @Override
            public void bindView(View view, Context context, final Cursor cursor) {
                TextView textName = (TextView) view.findViewById(R.id.cart_item_name);
                TextView textDesc = (TextView) view.findViewById(R.id.cart_item_description);
                TextView textPrice = (TextView) view.findViewById(R.id.cart_item_price);

                /* To put the following three lines into three separate AsyncTasks would make the
                does not save that much latency, so is it really still best practice to put it in the
                Async Tasks structure? */
                textName.setText(cursor.getString(cursor.getColumnIndex(DBHelper.CART_NAME)));
                textDesc.setText(cursor.getString(cursor.getColumnIndex(DBHelper.CART_DESCRIPTION)));
                textPrice.setText(cursor.getString(cursor.getColumnIndex(DBHelper.CART_PRICE)));


                final String finalName = cursor.getString(cursor.getColumnIndex(DBHelper.CART_NAME));
                final String finalDescription = cursor.getString(cursor.getColumnIndex(DBHelper.CART_DESCRIPTION));
                final String finalPrice = cursor.getString(cursor.getColumnIndex(DBHelper.CART_PRICE));

                final String itemId = cursor.getString(cursor.getColumnIndex(DBHelper.CART_ID));

                Button mItemPurchaseButton = (Button) view.findViewById(R.id.item_purchase_button);

                mItemPurchaseButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ShoppingCart.this, "Congratulations, you just bought a " + finalName, Toast.LENGTH_SHORT).show();
                        // adding item to the purchased table
                        if ((finalName != null) && (finalDescription != null) && (finalPrice != null)) {
                            addPurchasedItemToASyncTask(finalName,finalDescription,finalPrice);
                        }
                        // removing the item
                        removeItem(itemId);
                        DBHelper db = DBHelper.getInstance(ShoppingCart.this);

                        // next two lines are to use the AsyncTask
                        // using the Async task seems to refresh to a blank adapter screen
                        changeCursor(repopulationToASyncTask());
                        notifyDataSetChanged();
                        /* notifyDSChanged seems to not work anymore for cursors
                           Answer: The changeCursor swaps the old adapter for a new one, when called.
                        */
                    }
                });
            }
        };
//        cursorAdapter.notifyDataSetChanged(); This line is not needed for cursors apparently
        mlistView.setAdapter(cursorAdapter);
    }

    private Cursor addPurchasedItemToASyncTask(final String finalName, final String finalDescription, final String finalPrice) {
        mAddingTask = new AsyncTask<Void, Void, Void>() {
            DBHelper db = DBHelper.getInstance(ShoppingCart.this);

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(mContext, "Loading items", Toast.LENGTH_LONG).show();
            }

            @Override
            protected Void doInBackground(Void... params) {
                db.addPurchasedItemsFromCheckout(finalName, finalDescription, finalPrice);
                return null;
            }

            @Override
            protected void onPostExecute(Void object) {
                super.onPostExecute(object);
            }
        };
        mAddingTask.execute();
        return null;
    }

    private Cursor repopulationToASyncTask() {
        mRepopulationtask = new AsyncTask<Cursor, Integer, Cursor>() {
            DBHelper db = DBHelper.getInstance(ShoppingCart.this);

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(mContext, "Loading items", Toast.LENGTH_LONG).show();
            }

            @Override
            protected Cursor doInBackground(Cursor... params) {
                return db.getAllCartItems();
                // question ... why is this command now deleting every item in the 'Cart Table'?
                        // if I uncomment the changeCursor(db.getAllCartItems()); line it works
            }

            @Override
            protected void onPostExecute(Cursor object) {
                super.onPostExecute(object);
            }
        };
        mRepopulationtask.execute();
        return null;
    }


    public void removeItem(String id) {
        DBHelper db = DBHelper.getInstance(ShoppingCart.this);
        db.removeCartItem(id);
    }
}
