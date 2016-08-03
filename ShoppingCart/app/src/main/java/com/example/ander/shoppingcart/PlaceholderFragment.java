package com.example.ander.shoppingcart;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ander on 7/25/2016.
 */
public class PlaceholderFragment extends Fragment {

    Context mContext;
    ProgressBar mProgressBar;
    AsyncTask<List<ItemObject>, Integer, List<ItemObject>> mtask;


    private OnListItemClickListener mlistItemClickListener;
    private static final String TAB_NUMBER = "this_is_a_default_value";
    int tab_number = 0;
    RecyclerView mRecyclerView;
    SQLRecycleAdapter madapter;

    public interface OnListItemClickListener {
        void OnListItemClicked(int tabPosition, int listPosition);
    }

    public static PlaceholderFragment newInstance(int tab_number, OnListItemClickListener listener) {
        PlaceholderFragment placeholderFragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TAB_NUMBER, tab_number);
        // the following two set the arguments to the new Placeholder instance
        placeholderFragment.setArguments(bundle);
        placeholderFragment.mlistItemClickListener = listener;
        return placeholderFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String query_text = getArguments().getString("query_key");

        tab_number = getArguments().getInt(TAB_NUMBER, 0); //Getting the argument

        final View view = inflater.inflate(R.layout.recycle_view, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyler_widget);

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        mContext = this.getActivity();

        DBHelper dbHelper = DBHelper.getInstance(mContext);
        switch (tab_number) {
            case 0:
//                madapter = new SQLRecycleAdapter(addASyncDatabase(0), R.layout.recycle_view_items);
                // when I attempt to use the AsyncTask here it thinks the database is empty
                madapter = new SQLRecycleAdapter(dbHelper.getChelseaRentals(), R.layout.recycle_view_items);
                mRecyclerView.setAdapter(madapter);
                break;
            case 1:
//                madapter = new SQLRecycleAdapter(addASyncDatabase(1), R.layout.recycle_view_items);
                madapter = new SQLRecycleAdapter(dbHelper.getChelseaRentals(), R.layout.recycle_view_items);
                mRecyclerView.setAdapter(madapter);
                break;
            case 2:
//                madapter = new SQLRecycleAdapter(addASyncDatabase(2), R.layout.recycle_view_items);
                madapter = new SQLRecycleAdapter(dbHelper.getFulhamRentals(), R.layout.recycle_view_items);
                mRecyclerView.setAdapter(madapter);
                break;
            default:
//                madapter = new SQLRecycleAdapter(addASyncDatabase(3), R.layout.recycle_view_items);
                madapter = new SQLRecycleAdapter(dbHelper.getFruit(), R.layout.recycle_view_items);
                mRecyclerView.setAdapter(madapter);
        }
        return view;
    }

//    private List<ItemObject> addASyncDatabase(final int num){
//        mtask = new AsyncTask<List<ItemObject>, Integer, List<ItemObject>>() {
//            DBHelper db = DBHelper.getInstance(mContext);
//
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//                Toast.makeText(mContext, "Loading items", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            protected List<ItemObject> doInBackground(List<ItemObject>... params) {
//
//                for(int i=0; i < 15; i ++) {
//                    ItemObject itemObjectBa = new ItemObject("a name" + i, "a description" + i,  i + 1, "Battersea");
//                    ItemObject itemObjectCh = new ItemObject("a name" + i, "a description" + i,  i + 1, "Chelsea");
//                    ItemObject itemObjectFu = new ItemObject("a name" + i, "a description" + i,  i + 1, "Fulham");
//                    ItemObject itemObjectFr = new ItemObject("a name" + i, "a description" + i,  i + 1, "Fruit");
//                    db.insertRow(itemObjectBa);
//                    db.insertRow(itemObjectCh);
//                    db.insertRow(itemObjectFu);
//                    db.insertRow(itemObjectFr);
//                }
//
//                if (num == 0) {
//                    return DBHelper.getInstance(getContext()).getBatterseaRentals();
//                }
//                else if (num == 1) {
//                    return DBHelper.getInstance(getContext()).getChelseaRentals();
//                }
//
//                else if (num == 2) {
//                    return DBHelper.getInstance(getContext()).getFulhamRentals();
//                }
//                else {
//                    ArrayList<ItemObject> temp = new ArrayList<>();
//                    return DBHelper.getInstance(getContext()).getFruit();
//                }
//            }
//
//            @Override
//            protected void onPostExecute(List<ItemObject> object) {
//                super.onPostExecute(object);
//            }
//        };
//        mtask.execute();
//        return null;
//    }



    public void getQuery(String query, int position) {
        DBHelper dbHelper = DBHelper.getInstance(mContext);


        switch (tab_number) {
            case 0:
                madapter.updateRecViewItems(dbHelper.batterseaQuerySearch(query));
                break;
            case 1:
                madapter.updateRecViewItems(dbHelper.chelseaQuerySearch(query));
                break;
            case 2:
                madapter.updateRecViewItems(dbHelper.fulhamQuerySearch(query));
                break;
            default:
                madapter.updateRecViewItems(dbHelper.fruitQuerySearch(query));
        }
    }

}
