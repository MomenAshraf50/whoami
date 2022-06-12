package com.example.whoami.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whoami.R;

public class PersonalityViewActivity extends AppCompatActivity {

    ImageView imageViewPersonality;
    TextView textViewPersonalityName, textViewPersonalityInfo,textViewCharacteristicOne,textViewCharacteristicTwo
            ,textViewCharacteristicThree,textViewCharacteristicFour,textViewCharacteristicFive,textViewCharacteristicSix
            ,textViewToolBar;
    ImageButton imageButtonToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality_view);
        inet();
        textViewToolBar.setText("Personality Details");
        imageButtonToolBar.setImageResource(R.drawable.ic_baseline_close_24);
        getAndSetData();

    }
    public void inet(){
        imageButtonToolBar = findViewById(R.id.back_btn);
        textViewToolBar = findViewById(R.id.personalities_information_tv);
        imageViewPersonality = findViewById(R.id.personality_view_image_view);
        textViewPersonalityName = findViewById(R.id.personality_view_tv_name);
        textViewPersonalityInfo = findViewById(R.id.personality_view_tv_info);
        textViewCharacteristicOne = findViewById(R.id.characteristic_one);
        textViewCharacteristicTwo = findViewById(R.id.characteristic_two);
        textViewCharacteristicThree = findViewById(R.id.characteristic_three);
        textViewCharacteristicFour = findViewById(R.id.characteristic_four);
        textViewCharacteristicFive = findViewById(R.id.characteristic_five);
        textViewCharacteristicSix = findViewById(R.id.characteristic_six);

        imageButtonToolBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalityViewActivity.this.finish();
            }
        });
    }
    public void getAndSetData(){
        if (getIntent()!=null){
            String personalityName = getIntent().getStringExtra("personalityName");
            String personalityInfo = getIntent().getStringExtra("personalityInfo");
            int personalityImagePath = getIntent().getIntExtra("personalityImage",0);
            String personalityCharacteristicOne = getIntent().getStringExtra("personalityCharacteristicOne");
            String personalityCharacteristicTwo = getIntent().getStringExtra("personalityCharacteristicTwo");
            String personalityCharacteristicThree = getIntent().getStringExtra("personalityCharacteristicThree");
            String personalityCharacteristicFour = getIntent().getStringExtra("personalityCharacteristicFour");
            String personalityCharacteristicFive = getIntent().getStringExtra("personalityCharacteristicFive");
            String personalityCharacteristicSix = getIntent().getStringExtra("personalityCharacteristicSix");
            imageViewPersonality.setImageResource(personalityImagePath);
            textViewPersonalityName.setText(personalityName);
            textViewPersonalityInfo.setText(personalityInfo);
            textViewCharacteristicOne.append(personalityCharacteristicOne);
            textViewCharacteristicTwo.append(personalityCharacteristicTwo);
            textViewCharacteristicThree.append(personalityCharacteristicThree);
            textViewCharacteristicFour.append(personalityCharacteristicFour);
            textViewCharacteristicFive.append(personalityCharacteristicFive);
            textViewCharacteristicSix.append(personalityCharacteristicSix);
        }
    }
}