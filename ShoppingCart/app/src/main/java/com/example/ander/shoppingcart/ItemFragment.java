package com.example.ander.shoppingcart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by ander on 7/25/2016.
 */
public class ItemFragment extends Fragment{

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private PlaceholderFragment.OnListItemClickListener mItemListener;


    public static ItemFragment newInstance(PlaceholderFragment.OnListItemClickListener listener) {
        ItemFragment fragment = new ItemFragment();
        fragment.mItemListener = listener;
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.primary_item_fragment, parent, false);

        mViewPager = (ViewPager) rootView.findViewById(R.id.container);
        mTabLayout = (TabLayout) rootView.findViewById(R.id.tabs);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager(), mItemListener);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
