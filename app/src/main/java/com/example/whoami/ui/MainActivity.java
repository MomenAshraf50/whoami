package com.example.whoami.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
    ImageButton buttonModeToggle;
    boolean isDarkModeOn;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inet();
        sharedPreferences = MainActivity.this.getSharedPreferences("lightAndDark",MODE_PRIVATE);
        isDarkModeOn = sharedPreferences.getBoolean("darkModeStatus",false);

        if (isDarkModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            buttonModeToggle.setImageResource(R.drawable.light_mode_btn);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            buttonModeToggle.setImageResource(R.drawable.dark_mode_btn);
        }

        buttonModeToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDarkModeOn){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    buttonModeToggle.setImageResource(R.drawable.dark_mode_btn);
                    sharedPreferences.edit().putBoolean("darkModeStatus",false).apply();
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    buttonModeToggle.setImageResource(R.drawable.light_mode_btn);
                    sharedPreferences.edit().putBoolean("darkModeStatus",true).apply();
                }
            }
        });
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
                new AlertDialog.Builder(MainActivity.this)
                        .setCancelable(true)
                        .setMessage("Please, you should take this test seriously and do not think about the answers. Just pick up the first thing you tend to choose.\n" +
                                "Also you must be honest with yourself in your answers and make sure that there are no answers recorded for you anywhere and you will always remain anonymous")
                        .setTitle("Pay Attention")
                        .setPositiveButton("Ok, I understand", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(MainActivity.this,TestActivity.class));
                            }
                        }).show();

            }
        });

    }
    public void inet(){
        layout = findViewById(R.id.main_activity_layout);
        buttonMoreInfo = findViewById(R.id.main_activity_btn_more_info);
        buttonStartTheTest = findViewById(R.id.main_activity_btn_start_test);
        viewPager = findViewById(R.id.main_activity_view_pager);
        dotsIndicator = findViewById(R.id.dots_indicator);
        buttonModeToggle = findViewById(R.id.main_activity_btn_mode_toggle);

    }

}