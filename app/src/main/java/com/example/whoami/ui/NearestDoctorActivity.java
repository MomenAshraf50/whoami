package com.example.whoami.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.whoami.R;

public class NearestDoctorActivity extends AppCompatActivity {
    private static final String TAG = "NearestDoctorActivity";

    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearst_doctor);
        String city = getIntent().getStringExtra("city");
        Log.i(TAG, "onCreate: "+city);
        webView = findViewById(R.id.nearest_doctor_web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.vezeeta.com/en/doctor/psychiatry/"+city);
    }
}