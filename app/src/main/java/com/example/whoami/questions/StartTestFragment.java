package com.example.whoami.questions;

import android.content.Context;
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
                    return;
                }
                int ageNum = Integer.parseInt(age);
                if (ageNum > 100){
                    editTextAge.setError("Please, Enter a valid age");
                    return;
                }
                sharedPreferences = getActivity().getSharedPreferences("answers", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("age",age).apply();
                navController.navigate(R.id.action_startTestFragment_to_questionsGroupOneFragment);
            }
        });
    }
}