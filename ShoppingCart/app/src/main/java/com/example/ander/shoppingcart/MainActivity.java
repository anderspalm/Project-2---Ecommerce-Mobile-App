package com.example.ander.shoppingcart;

import android.app.Fragment;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PlaceholderFragment.OnListItemClickListener{

    ImageView mCartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mCartButton = (ImageView) findViewById(R.id.shopping_cart_logo);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.item_recycle_view_container, ItemFragment.newInstance(this))
                .commit();

        handleIntent(getIntent());

        mCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity", "onClick: FAB clicked");
                Toast.makeText(view.getContext(), "You clicked a button! Whoop whoop! " , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ShoppingCart.class);
                startActivity(intent);
            }
        });


    }



    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }


    private void handleIntent(Intent intent) {
        if(Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = getIntent().getStringExtra(SearchManager.QUERY);
            // TODO Put your code to handle the search here
//            Toast.makeText(MainActivity.this, "Searched for " + query, Toast.LENGTH_SHORT).show();

            Bundle bundle = new Bundle();
            bundle.putString("query_key", query);

            android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.item_recycle_view_container);

            String tagId = ((ItemFragment) fragment).getFragmentTagFromMain();
            android.support.v4.app.Fragment placeholderFragment = getSupportFragmentManager().findFragmentByTag(tagId);

            int position = ((ItemFragment) fragment).getPagerPosition();
//
           ((PlaceholderFragment) placeholderFragment).getQuery(query, position);
//            fragment.setArguments(bundle);

//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.detach(fragment);
//            fragmentTransaction.attach(fragment);
//            fragmentTransaction.commit();

        }
    }

    @Override
    public void OnListItemClicked(int tabPosition, int listPosition) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        ComponentName componentName = new ComponentName(MainActivity.this,MainActivity.class);

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));

        return true;
    }

}
