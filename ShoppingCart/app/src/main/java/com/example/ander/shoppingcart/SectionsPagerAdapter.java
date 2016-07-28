package com.example.ander.shoppingcart;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * Created by ander on 7/26/2016.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private PlaceholderFragment.OnListItemClickListener mItemClickListener;

    private int currentPage;

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
        return 4;
    }

    public Fragment getInstance(int position) {
        return PlaceholderFragment.newInstance(position, mItemClickListener);
    }

    public String getFragmentTagFromPager(int viewPagerId, int fragmentPosition) {
        return "android:switcher:" + viewPagerId + ":" + fragmentPosition;
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {
            default:
            case 0:
                return "Battersea";
            case 1:
                return "Chelsea";
            case 2:
                return "Fulham";
            case 3:
                return "Kensington";
        }
    }

    public int getItemPosition(int position) {
        return position;
    }
}
