package com.example.whoami.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import com.example.whoami.R;
import com.example.whoami.adapters.MoreInfoTabsAdapter;
import com.google.android.material.tabs.TabLayout;



public class MoreInformationActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 pager2;
    MoreInfoTabsAdapter adapter;
    ImageButton buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_information);

        buttonBack = findViewById(R.id.back_btn);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tabLayout = findViewById(R.id.more_info_tab_layout);
        pager2 = findViewById(R.id.more_information_activity_view_pager);

        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new MoreInfoTabsAdapter(fragmentManager,getLifecycle());
        pager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Factors"));
        tabLayout.addTab(tabLayout.newTab().setText("Personalities"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }

}