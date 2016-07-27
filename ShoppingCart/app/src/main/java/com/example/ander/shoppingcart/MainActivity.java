package com.example.ander.shoppingcart;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PlaceholderFragment.OnListItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.item_recycle_view_container, ItemFragment.newInstance(this))
                .commit();

        handleIntent(getIntent());
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
            Toast.makeText(MainActivity.this, "Searched for " + query, Toast.LENGTH_SHORT).show();

            Bundle bundle = new Bundle();
            bundle.putString("query_key", query);
            PlaceholderFragment placeholderFragment = new PlaceholderFragment();
            placeholderFragment.setArguments(bundle);
//            Intent sendIntent = new Intent();
//            sendIntent.setAction(Intent.ACTION_SEND);
//            sendIntent.putExtra("query_key", query);
//            sendIntent.setType("text/plain");
//            startActivity(sendIntent);
//            List<ItemObject> cursor = DBHelper.getInstance(this).searchNumbers(query);
//            Bundle bundle = new Bundle();
//            bundle.putString("query_key", String.valueOf(cursor));
//            PlaceholderFragment placeholderFragment = new PlaceholderFragment();
//            placeholderFragment.setArguments(bundle);

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
