package com.example.whoami.questions;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.whoami.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;

public class StartTestFragment extends Fragment {
    FloatingActionButton startTestButton;
    TextInputEditText editTextAge;
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_strat_test, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        startTestButton = view.findViewById(R.id.start_test_floating_btn);
        editTextAge = view.findViewById(R.id.start_test_age_et);
        startTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = editTextAge.getText().toString();

                if (age.isEmpty()){
                    editTextAge.setError("Please, Enter your age.");
                    YoYo.with(Techniques.Shake).duration(1000).playOn(editTextAge);
                    return;
                }
                if (age.contains(",")||age.contains(".")||age.contains("-")||age.contains(" ")){
                    editTextAge.setError("Enter a valid age");
                    YoYo.with(Techniques.Shake).duration(1000).playOn(editTextAge);
                    return;
                }
                int ageNum = Integer.parseInt(age);
                if(ageNum < 18){
                    new AlertDialog.Builder(getContext())
                            .setMessage("Sorry this test is designed for people over the age of 18")
                    .setPositiveButton("I understand", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).setCancelable(true).show();
                    return;
                }
                if (ageNum > 80){
                    editTextAge.setError("Please, Enter a valid age");
                    YoYo.with(Techniques.Shake).duration(1000).playOn(editTextAge);
                    return;
                }
                sharedPreferences = getActivity().getSharedPreferences("answers", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("age",age).apply();
                navController.navigate(R.id.action_startTestFragment_to_questionsGroupOneFragment);
            }
        });
    }
}