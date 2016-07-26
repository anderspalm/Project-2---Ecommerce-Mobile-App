package com.example.ander.shoppingcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PlaceholderFragment.OnListItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.item_recycle_view_container, ItemFragment.newInstance(this))
                .commit();
    }

    @Override
    public void OnListItemClicked(int tabPosition, int listPosition) {

    }
}
