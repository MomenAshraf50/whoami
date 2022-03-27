package com.example.whoami.questions;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.whoami.R;
import com.example.whoami.api.QuestionsResponse;
import com.example.whoami.api.RetrofitClient;
import com.example.whoami.api.Seven;
import com.example.whoami.api.Six;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QuestionsGroupSevenFragment extends Fragment {

    TextView textViewQuestionOne,textViewQuestionTwo,textViewQuestionThree,textViewQuestionFour
            ,textViewQuestionFive;
    private static final String TAG = "QuestionsGroupSevenFrag";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions_group_seven, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewQuestionOne = view.findViewById(R.id.test_page_seven_question_one);
        textViewQuestionTwo = view.findViewById(R.id.test_page_seven_question_two);
        textViewQuestionThree = view.findViewById(R.id.test_page_seven_question_three);
        textViewQuestionFour = view.findViewById(R.id.test_page_seven_question_four);
        textViewQuestionFive = view.findViewById(R.id.test_page_seven_question_five);

        RetrofitClient.getService().getQuestions()
                .enqueue(new Callback<QuestionsResponse>() {
                    @Override
                    public void onResponse(Call<QuestionsResponse> call, Response<QuestionsResponse> response) {
                        if (response.isSuccessful()&&response.body()!=null){
                            QuestionsResponse questionsResponse = response.body();
                            List<Seven> sevenList =questionsResponse.get7();
                            Seven one = sevenList.get(0);
                            String questionOne = one.getQuestion();
                            Seven two = sevenList.get(1);
                            String questionTwo = two.getQuestion();
                            Seven three = sevenList.get(2);
                            String questionThree = three.getQuestion();
                            Seven four = sevenList.get(3);
                            String questionFour = four.getQuestion();
                            Seven five = sevenList.get(4);
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
    }
}