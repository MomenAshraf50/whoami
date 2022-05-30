package com.example.whoami.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.whoami.R;
import com.example.whoami.adapters.MainScreenAdapter;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class MainActivity extends AppCompatActivity {
    Button buttonStartTheTest,buttonMoreInfo;
    RelativeLayout layout;
    AnimationDrawable drawable;
    ViewPager viewPager;
    DotsIndicator dotsIndicator;
    MainScreenAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inet();
        drawable = (AnimationDrawable) layout.getBackground();
        drawable.setEnterFadeDuration(1500);
        drawable.setExitFadeDuration(1000);
        drawable.start();

        adapter = new MainScreenAdapter(MainActivity.this);
        viewPager.setAdapter(adapter);
        dotsIndicator.setViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                    case 1:
                        buttonMoreInfo.setVisibility(View.GONE);
                        buttonStartTheTest.setVisibility(View.GONE);
                        break;
                    case 2:
                        buttonMoreInfo.setVisibility(View.VISIBLE);
                        buttonStartTheTest.setVisibility(View.VISIBLE);
                        YoYo.with(Techniques.FadeIn)
                                .duration(1000)
                                .playOn(findViewById(R.id.main_activity_linear_layout));
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        buttonMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MoreInformationActivity.class));
            }
        });
        buttonStartTheTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestActivity.class));
            }
        });


    }
    public void inet(){
        layout = findViewById(R.id.main_activity_layout);
        buttonMoreInfo = findViewById(R.id.main_activity_btn_more_info);
        buttonStartTheTest = findViewById(R.id.main_activity_btn_start_test);
        viewPager = findViewById(R.id.main_activity_view_pager);
        dotsIndicator = findViewById(R.id.dots_indicator);
    }



}