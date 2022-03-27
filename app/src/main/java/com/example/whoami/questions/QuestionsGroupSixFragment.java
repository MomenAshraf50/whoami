package com.example.whoami.questions;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.whoami.R;
import com.example.whoami.api.Five;
import com.example.whoami.api.QuestionsResponse;
import com.example.whoami.api.RetrofitClient;
import com.example.whoami.api.Six;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QuestionsGroupSixFragment extends Fragment {

    FloatingActionButton pageSixButton;
    TextView textViewQuestionOne,textViewQuestionTwo,textViewQuestionThree,textViewQuestionFour
            ,textViewQuestionFive;
    private static final String TAG = "QuestionsGroupSixFragme";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions_group_six, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);

        textViewQuestionOne = view.findViewById(R.id.test_page_six_question_one);
        textViewQuestionTwo = view.findViewById(R.id.test_page_six_question_two);
        textViewQuestionThree = view.findViewById(R.id.test_page_six_question_three);
        textViewQuestionFour = view.findViewById(R.id.test_page_six_question_four);
        textViewQuestionFive = view.findViewById(R.id.test_page_six_question_five);

        RetrofitClient.getService().getQuestions()
                .enqueue(new Callback<QuestionsResponse>() {
                    @Override
                    public void onResponse(Call<QuestionsResponse> call, Response<QuestionsResponse> response) {
                        if (response.isSuccessful()&&response.body()!=null){
                            QuestionsResponse questionsResponse = response.body();
                            List<Six> sixList =questionsResponse.get6();
                            Six one = sixList.get(0);
                            String questionOne = one.getQuestion();
                            Six two = sixList.get(1);
                            String questionTwo = two.getQuestion();
                            Six three = sixList.get(2);
                            String questionThree = three.getQuestion();
                            Six four = sixList.get(3);
                            String questionFour = four.getQuestion();
                            Six five = sixList.get(4);
                            String questionFive = five.getQuestion();
                            textViewQuestionOne.setText(questionOne);
                            textViewQuestionTwo.setText(questionTwo);
                            textViewQuestionThree.setText(questionThree);
                            textViewQuestionFour.setText(questionFour);
                            textViewQuestionFive.setText(questionFive);


                        }
                    }

                    @Override
                    public void onFailure(Call<QuestionsResponse> call, Throwable t) {
                        String error = t.getMessage();
                        Log.i(TAG, "onFailure: " + error);
                    }
                });

        pageSixButton = view.findViewById(R.id.test_page_six_floating_btn);
        pageSixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_questionsGroupSixFragment_to_questionsGroupSevenFragment);
            }
        });
    }
}