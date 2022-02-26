package com.example.whoami;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonalityViewActivity extends AppCompatActivity {

    ImageView imageViewPersonality;
    TextView textViewPersonalityName, textViewPersonalityInfo,textViewCharacteristicOne,textViewCharacteristicTwo
            ,textViewCharacteristicThree,textViewCharacteristicFour,textViewCharacteristicFive,textViewCharacteristicSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality_view);
        inet();
        getAndSetData();

    }
    public void inet(){

        imageViewPersonality = findViewById(R.id.personality_view_image_view);
        textViewPersonalityName = findViewById(R.id.personality_view_tv_name);
        textViewPersonalityInfo = findViewById(R.id.personality_view_tv_info);
        textViewCharacteristicOne = findViewById(R.id.characteristic_one);
        textViewCharacteristicTwo = findViewById(R.id.characteristic_two);
        textViewCharacteristicThree = findViewById(R.id.characteristic_three);
        textViewCharacteristicFour = findViewById(R.id.characteristic_four);
        textViewCharacteristicFive = findViewById(R.id.characteristic_five);
        textViewCharacteristicSix = findViewById(R.id.characteristic_six);
    }
    public void getAndSetData(){
        if (getIntent()!=null){
            String personalityName = getIntent().getStringExtra("personalityName");
            String personalityInfo = getIntent().getStringExtra("personalityInfo");
            int personalityImagePath = getIntent().getIntExtra("personalityImage",0);
            String personalityCharacteristicOne = getIntent().getStringExtra("PersonalityCharacteristicOne");
            String personalityCharacteristicTwo = getIntent().getStringExtra("PersonalityCharacteristicTwo");
            String personalityCharacteristicThree = getIntent().getStringExtra("PersonalityCharacteristicThree");
            String personalityCharacteristicFour = getIntent().getStringExtra("PersonalityCharacteristicFour");
            String personalityCharacteristicFive = getIntent().getStringExtra("PersonalityCharacteristicFive");
            String personalityCharacteristicSix = getIntent().getStringExtra("PersonalityCharacteristicSix");
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