package com.example.frontend_insta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class notification extends AppCompatActivity {
    TabLayout tab;
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        tab=findViewById(R.id.tab);
        viewpager=findViewById(R.id.viewpager);

        viewpagerAdaptor adaptor=new viewpagerAdaptor(getSupportFragmentManager());
        viewpager.setAdapter(adaptor);
        tab.setupWithViewPager(viewpager);

    }
}