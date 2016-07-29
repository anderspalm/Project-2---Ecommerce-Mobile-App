package com.example.ander.shoppingcart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDisplayActivity extends AppCompatActivity {

    ImageView mCartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_display);

        Intent intent = getIntent();
        String clicked_item_name = intent.getStringExtra("name_key");
        String clicked_item_description = intent.getStringExtra("desc_key");
        String clicked_item_price = intent.getStringExtra("price_key");


        TextView textName = (TextView) findViewById(R.id.inflated_item_name);
        TextView textDesc = (TextView) findViewById(R.id.inflated_item_description);
        TextView textPrice = (TextView) findViewById(R.id.inflated_item_price);

        textName.setText(clicked_item_name);
        textDesc.setText(clicked_item_description);
        textPrice.setText(clicked_item_price);

        mCartButton = (ImageView) findViewById(R.id.add_to_cart_button_in_item_inflation);

        mCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity", "onClick: FAB clicked");
//                Toast.makeText(view.getContext(), "Cart button works " , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ItemDisplayActivity.this, ShoppingCart.class);
                startActivity(intent);
            }
        });

    }
}
