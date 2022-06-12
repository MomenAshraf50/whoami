package com.example.whoami.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whoami.PersonalityDetails;
import com.example.whoami.R;
import com.example.whoami.adapters.MainScreenAdapter;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ResultActivity extends AppCompatActivity {
    private static final String TAG = "ResultActivity";
    int personalityNum ;
    List<PersonalityDetails> personalityDetailsList = new ArrayList<>();

    int image;
    String personalityInfo,personalityName,personalityCharacteristicOne,personalityCharacteristicTwo
            ,personalityCharacteristicThree,personalityCharacteristicFour,personalityCharacteristicFive
            ,personalityCharacteristicSix;
    ViewPager viewPager;
   /* FusedLocationProviderClient fusedLocationProviderClient;
    Geocoder geocoder;
    List<Address> addresses;
    Locale loc = new Locale("en");*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        personalityNum = getIntent().getIntExtra("personalityNum",2);
        

       /* textViewPersonalityResult = findViewById(R.id.result_personality_tv);
        imageViewPersonalityImage = findViewById(R.id.result_iv);
        buttonPersonalityInfo = findViewById(R.id.result_personality_info_btn);
        buttonGetHelp = findViewById(R.id.result_get_help_btn);*/

       /* fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);*/

        personalityData();
        if (personalityNum== 2){
            getData(0);

        }
        if (personalityNum== 3){
            getData(1);
        }
        if (personalityNum== 4){
            getData(2);

        }
        if (personalityNum== 5){
            getData(3);

        }
        if (personalityNum== 6){
            getData(4);

        }
        if (personalityNum== 7){
            getData(5);

        }
        if (personalityNum== 8){
            getData(6);

        }
        if (personalityNum== 9){
            getData(7);
            }
        /*buttonPersonalityInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, PersonalityViewActivity.class);
                intent.putExtra("personalityImage",image);
                intent.putExtra("personalityInfo",personalityInfo);
                intent.putExtra("personalityName",personalityName);
                intent.putExtra("personalityCharacteristicOne",personalityCharacteristicOne);
                intent.putExtra("personalityCharacteristicTwo",personalityCharacteristicTwo);
                intent.putExtra("personalityCharacteristicThree",personalityCharacteristicThree);
                intent.putExtra("personalityCharacteristicFour",personalityCharacteristicFour);
                intent.putExtra("personalityCharacteristicFive",personalityCharacteristicFive);
                intent.putExtra("personalityCharacteristicSix",personalityCharacteristicSix);
                startActivity(intent);
            }
        });*/

        /*buttonGetHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askForPermission();
            }
        });*/
    }

   /* private void askForPermission() {
        Dexter.withContext(this)
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        getLastLocation();
                        
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        new AlertDialog.Builder(ResultActivity.this)
                                .setCancelable(true)
                                .setPositiveButton("Ok, I'll allow the permission", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        askForPermission();
                                    }
                                }).setMessage("We can't suggest you the nearest doctor if you deny location permission")
                                .setTitle("Permission Denied")
                                .show();


                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
    }

    private void getLastLocation() {
        @SuppressLint("MissingPermission")
        Task<Location> locationTask = fusedLocationProviderClient.getLastLocation();
        locationTask.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null){
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    geocoder = new Geocoder(ResultActivity.this, Locale.getDefault());
                    try {
                        addresses = geocoder.getFromLocation(latitude,longitude,1);
                    } catch (IOException e) {
                        Log.i(TAG, "onSuccess: "+ e.getMessage());
                    }

                    String city = addresses.get(0).getAdminArea();
                    String arr[] = city.split(" ", 2);

                    city = arr[0];


                    Intent intent = new Intent(ResultActivity.this, NearestDoctorActivity.class);
                    intent.putExtra("city",city);
                    startActivity(intent);


                }else {
                    Log.i(TAG, "onSuccess: Location is null");
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                String errorMessage = e.getMessage();
                Log.i(TAG, "onFailure: "+errorMessage);

            }
        });
    }*/

    public void personalityData(){
        personalityDetailsList.add(new PersonalityDetails(R.drawable.passionate,"Passionate"
                ,"The strong feeling, energy, and strength that come from focusing on what excites you. She is a character who is both lively and emotional. She is one of the personalities who is very interested in achieving her desires and achieving scientific and social success. He is someone who loves strength and leadership, has strong management and can sometimes be ruthless, owners give people around them hope for a happy and exciting future and they feel that they have a purpose and that they are right. Steady steps in life."
                ,"A character who devoted his life to making dreams come true."
                ,"Sometimes she starts her day early and prefers morning to evening."
                ,"Surrounding herself with her work “work is life” (behavior modification)."
                ,"Pushing forward with full force (behavior modification)."
                ,"It has a special charm and is inspiring to others."
                ,"High concentration and keenness not to waste time on secondary matters."));
        personalityDetailsList.add(new PersonalityDetails(R.drawable.inferiority,"Inferiority"
                ,"It is an unconscious psychological deficiency in which a person feels a physical, psychological, or social deficiency or deficiency in a way that affects his behavior. Beyond this feeling, it seems to be complicated by the multiplication and intensification of feelings of inferiority through frustration or feeling of inferiority for various reasons in life such as gender, race, family, social class, mental or physical health appearance and they don't feel they can solve or master."
                ,"He is satisfied with the marginal roles in life."
                ,"Assuming a lower rank in dealing with others (behavior modification)."
                ,"Always rely on others."
                ,"Lacks a sense of confidence and independence (behavior modification)."
                ,"Exaggeration in thanking those around him."
                ,"Always convinced that he is in a state of submission and surrender (behavior modification)."));
        personalityDetailsList.add(new PersonalityDetails(R.drawable.hysterical,"Hysterical",
                " It is a term in which a person seeks attention, attention and the attention of his companions with emotional reactions and exaggeration in describing situations and people suffering from depression and the emergence and focus of the focus on the cause of a defect in the house. The product of exposure to the breasts the product of exposure to the breasts is the effect of their owners on temptation. The central nervous system is largely caused by genetics",
                "Self-love and caring about himself."
                ,"Feeling uncomfortable (behavior modification)."
                ,"Great attention to appearance and its sustainability to attract attention."
                ,"Overlooking defects and seeking to fix them (behavior modification)."
                ,"Their emotions are childish, volatile, complex, and superficial."
                ,"The strength of the ability to be patient and persevere (reinforcement of behavior)."));
        personalityDetailsList.add(new PersonalityDetails(R.drawable.narcissistic,"Narcissistic"
                ,"It is a psychological state in which there is a feeling of exaggeration of importance, as well as a deep need for increased attention and admiration, disorder of relationships, lack of empathy for others, but behind this exaggerated mask of overconfidence is weak. Self-confidence that makes him vulnerable to the least amount of criticism and this disorder causes many problems in areas of life such as relationships, work or finances, and they are not satisfied with their relationships most of the time and get frustrated in general. Among the causes of this disorder are: Environment: incompatibility in relationships through excessive admiration or excessive criticism, genetic factors ,Neurobiology: the link between the brain, behavior and thinking."
                ,"Arrogance and arrogance, then arrogance and boasting (behavior modification)."
                ,"Difficulty dealing with enemies."
                ,"Exaggerating their achievements and talents."
                ,"Stay away from their enemies to appear superior."
                , "Monopolizing speech and belittling those who look at them (behavior modification)."
                ,"They envy others and think that others limit them as well."));
        personalityDetailsList.add(new PersonalityDetails(R.drawable.introverted,"introverted"
                ,"Set in the 1960s, a character who tends to exist in quiet environments far from human gatherings to regain her energy. Too much human interaction, so it pushes them to withdraw from some social situations, which can sometimes make them appear rude, and it is a trait that focuses on self and personal feelings rather than external factors and sources of motivation, and their presence in the world ranges from 25% to 40%."
                ,"They have great charisma."
                ,"He does not tend to start the conversation and does not prefer to engage in regular short conversations (behavior modification)."
                ,"Others tend to consult him and take his opinion on many difficult and sensitive life decisions."
                ,"He usually avoids situations of confrontation, conflict and disagreement."
                ,"He tends to meditate alone, like daydreaming."
                ,"Sensitive to mood, irritable."));
        personalityDetailsList.add(new PersonalityDetails(R.drawable.compulsive,"Compulsive",
                "It is a permanent pattern of internal emotions, feelings, and external behavior and appears in perception, emotion, affection, impulse control, interaction with surrounding people, and this pattern is permanent and long-term and controls personal or social situations and usually leads This disorder tends to be orderly, elegant, and perfect, and its people feel a strong need to impose their own standards on their external environment.",
                "Often experience social isolation (behavior modification)."
                ,"They have difficulty forming and maintaining close relationships with others."
                ,"They work hard but their obsession with perfection can make them ineffective (behavior modification)."
                ,"They do not follow the whims of others, believing that they have the right opinion,"
                ,"They choose their friends very carefully, but they have many acquaintances."
                ,"Everything is subject to the workings of the mind."));
        personalityDetailsList.add(new PersonalityDetails(R.drawable.persecuted,"Persecuted"
                ,"He is a person who loves controversy, fierce defender of his opinions, sticks to his ideas, masters the role of victim, and you will not be able to win against him in any debate because he has a tremendous ability. To come out with millions of arguments and justifications why he is right while he restricts your freedom and invades your personal space and questions your movements and follows the details of your life and activities moment by moment Under the feeling that he takes care of you and loves you Always does not trust others because he loses confidence in everything in life He is always sensitive and skeptical about others and his reasons They are the environmental factor, motivation, genetic factor and recurrent psychological traits."
                ,"Fear of using something against him (behavior modification)."
                ,"very sensitive and does not accept anything."
                ,"Does not accept criticism (behavior modification)."
                ,"Discharge arrogance from within."
                ,"The patient's suspicion of a life partner (behavior modification)."
                ,"Bad and unjustified explanations (behavior modification)."));
        personalityDetailsList.add(new PersonalityDetails(R.drawable.psychopathic,"Psychopathic",
                "It is an anti-social personality, any person who shows patterns of manipulation and violation of others, which contradicts this behavior with the rules and behaviors of society, and he is a person with a mental illness called “psychopathy” but does not adopt the official diagnosis, some people develop psychopathy when 18 years old, but some signs of behavioral disorder appear since childhood, and the cause of psychopathy is gender, which males are more susceptible to this disease and be genetics, behavioral disorder, exposure to trauma, or unstable childhood.",
                "Have a high level of intelligence."
                ,"General disregard for responsibility and safety (behavior modification)."
                ,"Emotional immaturity and lack of judgment (behavior modification)."
                ,"Outward impulsivity from voluntary control (behavior modification)."
                ,"Not showing sympathy and regret over things."
                ,"Taking this disorder in a harmful or anti-social direction (behavior modification)."));

        personalityDetailsList.add(new PersonalityDetails(R.drawable.natural_personality,"Natural",
                "Scientists have differed on the interpretation and evaluation of the natural personality and its identification, despite the difference over it, but there is a concept that is common among scientists and individuals, which is that the natural personality means free from psychological and mental disturbances and that enjoys their sound health, and it is the one who enjoys sobriety of mind, emotional stability and activity It is sufficient and a full investment of all its capabilities and is compatible with its environment with all its components and does its best and is not at war with itself or with others, and it is the right person to acquire rights and bear the burden of responsibilities and obligations"
                ,"Lack of distinction between the heart and the mind, as they are two essential organs.",
                " Control oneself and desires with sobriety and wisdom.",
                " Persuasion of any action and before any action.",
                "He does not consume his mind in what is not useful and does not think in an exaggerated way.",
                "Everything is given its due, whether it is in anger or joy.",
                "He looks at every difficult situation with the view of a philosopher, as he learns from every predicament that happens to him."));





    }
    public void getData(int num){
        PersonalityDetails personalityDetails = personalityDetailsList.get(num);
        image = personalityDetails.getImagePath();
        personalityName = personalityDetails.getPersonalityName();
        personalityInfo = personalityDetails.getPersonalityInfo();
        personalityCharacteristicOne = personalityDetails.getPersonalityCharacteristicOne();
        personalityCharacteristicTwo = personalityDetails.getPersonalityCharacteristicTwo();
        personalityCharacteristicThree = personalityDetails.getPersonalityCharacteristicThree();
        personalityCharacteristicFour = personalityDetails.getPersonalityCharacteristicFour();
        personalityCharacteristicFive = personalityDetails.getPersonalityCharacteristicFive();
        personalityCharacteristicSix = personalityDetails.getPersonalityCharacteristicSix();

        viewPager = findViewById(R.id.result_view_pager);
        int[] imageList = {image,R.drawable.characteristic_one,R.drawable.characteristic_two,R.drawable.characteristic_three
        ,R.drawable.characteristic_four,R.drawable.characteristic_five,R.drawable.characteristic_six};
        String[] head = {"You Personality is "+personalityName,"Characteristic One","Characteristic Two","Characteristic Three",
                "Characteristic Four","Characteristic Five","Characteristic six"};
        String[] content = {"Slide to know personality characteristics",personalityCharacteristicOne,personalityCharacteristicTwo,
        personalityCharacteristicThree,personalityCharacteristicFour,personalityCharacteristicFive,personalityCharacteristicSix};
        MainScreenAdapter adapter = new MainScreenAdapter(ResultActivity.this,imageList,head,content);
        viewPager.setAdapter(adapter);
        DotsIndicator dotsIndicator;
        dotsIndicator = findViewById(R.id.result_dots_indicator);
        dotsIndicator.setViewPager(viewPager);


    }
}