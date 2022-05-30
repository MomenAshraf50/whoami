package com.example.whoami.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.whoami.R;
import com.example.whoami.questions.QuestionsGroupOneFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

public class TestActivity extends AppCompatActivity {
    FragmentContainerView fragment;
    ProgressBar progressBar;
    int counter = 0;
    private static final String TAG = "TestActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        fragment = findViewById(R.id.fragmentContainerView);
        QuestionsGroupOneFragment questionsGroupOneFragment = new QuestionsGroupOneFragment();
        int progress = questionsGroupOneFragment.progressBarOne;
        Log.i(TAG, "onCreate: "+progress);




    }



}