package com.example.frontend_insta;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class viewpagerAdaptor extends FragmentPagerAdapter {

    public viewpagerAdaptor(@NonNull FragmentManager fm) {
        super(fm);
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return  new notificationFragment();
        }
        else{
            return  new requestFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if(position==0){
            return  "notification";
        }
        else{
            return  "request";
        }
    }
}
