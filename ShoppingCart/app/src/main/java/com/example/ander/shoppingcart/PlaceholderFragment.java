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

        mProgressBar = (ProgressBar) view.findViewById(R.id.progress);

        DBHelper dbHelper = DBHelper.getInstance(mContext);
        switch (tab_number) {
            case 0:
                addASyncDatabase(0);
                break;
            case 1:
                addASyncDatabase(1);
                break;
            case 2:
                addASyncDatabase(2);
                break;
            default:
                addASyncDatabase(3);
//                The next two lines are what I had prior to the AsyncTask
//                madapter = new SQLRecycleAdapter(dbHelper.getAccessories(), R.layout.recycle_view_items);
//                mRecyclerView.setAdapter(madapter);
        }
        return view;
    }

    private ArrayList<ItemObject> addASyncDatabase(final int num) {
        mtask = new AsyncTask<List<ItemObject>, Integer, List<ItemObject>>() {
            DBHelper db = DBHelper.getInstance(mContext);

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(mContext, "Loading items", Toast.LENGTH_LONG).show();
//                mProgressBar.setVisibility(View.VISIBLE);
            }

//            @Override
//            protected void onProgressUpdate(Integer... values) {
//                super.onProgressUpdate(values);
////                mProgressBar.setProgress(values[0]);
//            }

            @Override
            protected List<ItemObject> doInBackground(List<ItemObject>... params) {
                if (num == 0) {
                    return DBHelper.getInstance(getContext()).getComputers();
                } else if (num == 1) {
                    return DBHelper.getInstance(getContext()).getConsoles();
                } else if (num == 2) {
                    return DBHelper.getInstance(getContext()).getTelevisions();
                } else if (num == 3){
                    return DBHelper.getInstance(getContext()).getAccessories();
//                    List object = DBHelper.getInstance(getContext()).getComputers();
//                    Integer progressVal = object.size();
//                    for (int j = 0; j < progressVal; j++) {
//                        publishProgress(progressVal);
//                    }
//                    return object;
                }
                else {
                    return null;
                }
            }

            @Override
            protected void onPostExecute(List<ItemObject> object) {
                super.onPostExecute(object);

                madapter = new SQLRecycleAdapter(object, R.layout.recycle_view_items);
                mRecyclerView.setAdapter(madapter);
            }
        };
        mtask.execute();
        return null;
    }


    public void getQuery(String query, int position) {
        DBHelper dbHelper = DBHelper.getInstance(mContext);

        switch (tab_number) {
            case 0:
                madapter.updateRecViewItems(dbHelper.computerQuerySearch(query));
                break;
            case 1:
                madapter.updateRecViewItems(dbHelper.consolesQuerySearch(query));
                break;
            case 2:
                madapter.updateRecViewItems(dbHelper.televisionQuerySearch(query));
                break;
            default:
                madapter.updateRecViewItems(dbHelper.accessoriesQuerySearch(query));
        }
    }

}
