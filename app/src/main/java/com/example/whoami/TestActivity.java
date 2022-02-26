package com.example.whoami;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class TestActivity extends AppCompatActivity {

    //TabLayout tabLayout;
    //ViewPager2 viewPager2;
    //TestTapsAdapter testTapsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        /*tabLayout = findViewById(R.id.test_tab_layout);
        viewPager2 = findViewById(R.id.test_view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        testTapsAdapter = new TestTapsAdapter(fragmentManager,getLifecycle());
        viewPager2.setAdapter(testTapsAdapter);
        tabLayout.addTab(tabLayout.newTab().setText("Questions 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Questions 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Questions 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Questions 4"));
        tabLayout.addTab(tabLayout.newTab().setText("Questions 5"));
        tabLayout.addTab(tabLayout.newTab().setText("Questions 6"));
        tabLayout.addTab(tabLayout.newTab().setText("Questions 7"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });*/

    }
}