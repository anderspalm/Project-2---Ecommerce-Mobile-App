package com.example.ander.shoppingcart;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ander on 7/25/2016.
 */
public class PlaceholderFragment extends Fragment {

    Context mContext;

    private OnListItemClickListener mlistItemClickListener;
    private static final String TAB_NUMBER = "this_is_a_default_value";
    int tab_number = 0;
    RecyclerView mRecyclerView;

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

        tab_number = getArguments().getInt(TAB_NUMBER, 0); //Getting the argument

        View view = inflater.inflate(R.layout.recycle_view, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyler_widget);


        mContext = this.getActivity();

        switch (tab_number) {
            case 0:
                String query_text = getArguments().getString("query_key");
                if (query_text == null) {

                    RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
                    mRecyclerView.setLayoutManager(gridLayoutManager);

                    DBHelper dbHelper = DBHelper.getInstance(mContext);
                    SQLRecycleAdapter adapter = new SQLRecycleAdapter(dbHelper.getBatterseaRentals(), R.layout.recycle_view_items);

                    mRecyclerView.setAdapter(adapter);
                }

                else {
                    RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
                    mRecyclerView.setLayoutManager(gridLayoutManager);

                    DBHelper dbHelper = DBHelper.getInstance(mContext);
                    SQLRecycleAdapter adapter = new SQLRecycleAdapter(dbHelper.searchNumbers(query_text), R.layout.recycle_view_items);

                    mRecyclerView.setAdapter(adapter);
                }

                break;
            case 1:
                RecyclerView.LayoutManager gridLayoutManager1 = new GridLayoutManager(mContext,2);
                mRecyclerView.setLayoutManager(gridLayoutManager1);

                DBHelper dbHelper1 = DBHelper.getInstance(mContext);
                SQLRecycleAdapter adapter1 = new SQLRecycleAdapter(dbHelper1.getChelseaRentals(), R.layout.recycle_view_items);

                mRecyclerView.setAdapter(adapter1);

                break;
            case 2:
                RecyclerView.LayoutManager gridLayoutManager2 = new GridLayoutManager(mContext,2);
                mRecyclerView.setLayoutManager(gridLayoutManager2);

                DBHelper dbHelper2 = DBHelper.getInstance(mContext);
                SQLRecycleAdapter adapter2 = new SQLRecycleAdapter(dbHelper2.getFulhamRentals(), R.layout.recycle_view_items);

                mRecyclerView.setAdapter(adapter2);

                break;
            default:
                RecyclerView.LayoutManager gridLayoutManager3 = new GridLayoutManager(mContext,2);
                mRecyclerView.setLayoutManager(gridLayoutManager3);

                DBHelper dbHelper3 = DBHelper.getInstance(mContext);
                SQLRecycleAdapter adapter3 = new SQLRecycleAdapter(dbHelper3.getKnightsbridgeRentals(), R.layout.recycle_view_items);

                mRecyclerView.setAdapter(adapter3);

                break;
        }
        return view;
    }

    public void onViewCreated(ViewGroup viewGroup, Bundle savedInstanceState) {
        super.onViewCreated(viewGroup, savedInstanceState);
//        mRecyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view);

    }
}
