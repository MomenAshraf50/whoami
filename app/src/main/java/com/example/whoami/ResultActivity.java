package com.example.whoami;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.whoami.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultActivity extends AppCompatActivity {
    private static final String TAG = "ResultActivity";
    int personalityNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        personalityNum = getIntent().getIntExtra("personalityNum",0);
        Log.i(TAG, "onCreate: "+personalityNum);
    }
}