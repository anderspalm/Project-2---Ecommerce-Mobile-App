package com.example.ander.shoppingcart;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ander on 7/26/2016.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private PlaceholderFragment.OnListItemClickListener mItemClickListener;

    public SectionsPagerAdapter(FragmentManager fm, PlaceholderFragment.OnListItemClickListener listener) {
        super(fm);
        mItemClickListener = listener;
    }

    @Override
    public Fragment getItem(int position) {
        return PlaceholderFragment.newInstance(position, mItemClickListener);
    }

    @Override
    public int getCount() {
        return 3;
    }

    public Fragment getInstance(int position) {
        return PlaceholderFragment.newInstance(position, mItemClickListener);
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {
            default:
            case 0:
                return "Knights Bridge";
            case 1:
                return "Chelsea";
            case 2:
                return "Kensington";
        }
    }

}
