package com.example.whoami.questions;

import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.whoami.R;
import com.example.whoami.api.One;
import com.example.whoami.api.QuestionsResponse;
import com.example.whoami.api.RetrofitClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QuestionsGroupOneFragment extends Fragment {
    public final int progressBarOne=1;
    RadioGroup radioGroupAnswerOne,radioGroupAnswerTwo,radioGroupAnswerThree,radioGroupAnswerFour
            ,radioGroupAnswerFive;
    RadioButton radioButtonAnswerOne,radioButtonAnswerTwo,radioButtonAnswerThree,radioButtonAnswerFour
            ,radioButtonAnswerFive;
    String answerOne,answerTwo,answerThree,answerFour,answerFive;
    FloatingActionButton pageOneButton;
    TextView textViewQuestionOne,textViewQuestionTwo,textViewQuestionThree,textViewQuestionFour
            ,textViewQuestionFive;
    
    SharedPreferences sharedPreferences;
    ScrollView scrollView;
    ProgressBar progressBar;

    private static final String TAG = "QuestionsGroupOneFragme";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions_group_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);

        inet(view);
        animation(view);
        RetrofitClient.getService().getQuestions()
                .enqueue(new Callback<QuestionsResponse>() {
                    @Override
                    public void onResponse(Call<QuestionsResponse> call, Response<QuestionsResponse> response) {
                        if (response.isSuccessful()&&response.body()!=null){
                            QuestionsResponse questionsResponse = response.body();
                            List<One> oneList =questionsResponse.get1();
                            One one = oneList.get(0);
                            String questionOne = one.getQuestion();

                            One two = oneList.get(1);
                            String questionTwo = two.getQuestion();
                            One three = oneList.get(2);
                            String questionThree = three.getQuestion();
                            One four = oneList.get(3);
                            String questionFour = four.getQuestion();
                            One five = oneList.get(4);
                            String questionFive = five.getQuestion();
                            if (questionFive.isEmpty()){
                                scrollView.setVisibility(View.GONE);
                            }else {
                                progressBar.setVisibility(View.GONE);
                            }
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


        pageOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int answerOneId = radioGroupAnswerOne.getCheckedRadioButtonId();
                int answerTwoId = radioGroupAnswerTwo.getCheckedRadioButtonId();
                int answerThreeId = radioGroupAnswerThree.getCheckedRadioButtonId();
                int answerFourId = radioGroupAnswerFour.getCheckedRadioButtonId();
                int answerFiveId = radioGroupAnswerFive.getCheckedRadioButtonId();

                if (answerOneId==-1||answerTwoId==-1||answerThreeId==-1||answerFourId==-1
                ||answerFiveId==-1){
                    Toast.makeText(getContext(), "Please, answer all Questions", Toast.LENGTH_SHORT).show();
                    if (answerOneId==-1){
                        YoYo.with(Techniques.Shake).duration(1000).playOn(view.findViewById(R.id.test_page_one_question_one_card_view));
                    }
                    if (answerTwoId==-1){
                        YoYo.with(Techniques.Shake).duration(1000).playOn(view.findViewById(R.id.test_page_one_question_two_card_view));
                    }
                    if (answerThreeId==-1){
                        YoYo.with(Techniques.Shake).duration(1000).playOn(view.findViewById(R.id.test_page_one_question_three_card_view));
                    }
                    if (answerFourId==-1){
                        YoYo.with(Techniques.Shake).duration(1000).playOn(view.findViewById(R.id.test_page_one_question_four_card_view));
                    }
                    if (answerFiveId==-1){
                        YoYo.with(Techniques.Shake).duration(1000).playOn(view.findViewById(R.id.test_page_one_question_five_card_view));return;
                    }

                    return;
                }


                radioButtonAnswerOne = view.findViewById(answerOneId);
                radioButtonAnswerTwo = view.findViewById(answerTwoId);
                radioButtonAnswerThree = view.findViewById(answerThreeId);
                radioButtonAnswerFour = view.findViewById(answerFourId);
                radioButtonAnswerFive = view.findViewById(answerFiveId);


                answerOne =  radioButtonAnswerOne.getText().toString();
                answerTwo =  radioButtonAnswerTwo.getText().toString();
                answerThree =  radioButtonAnswerThree.getText().toString();
                answerFour =  radioButtonAnswerFour.getText().toString();
                answerFive =  radioButtonAnswerFive.getText().toString();


                sharedPreferences = getActivity().getSharedPreferences("answers", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("pageOneAnswerOne",answerOne).apply();
                sharedPreferences.edit().putString("pageOneAnswerTwo",answerTwo).apply();
                sharedPreferences.edit().putString("pageOneAnswerThree",answerThree).apply();
                sharedPreferences.edit().putString("pageOneAnswerFour",answerFour).apply();
                sharedPreferences.edit().putString("pageOneAnswerFive",answerFive).apply();



                navController.navigate(R.id.action_questionsGroupOneFragment_to_questionsGroupTwoFragment);





            }
        });

    }
    public void inet(View view){
        pageOneButton = view.findViewById(R.id.test_page_one_floating_btn);
        textViewQuestionOne = view.findViewById(R.id.test_page_one_question_one);
        textViewQuestionTwo = view.findViewById(R.id.test_page_one_question_two);
        textViewQuestionThree = view.findViewById(R.id.test_page_one_question_three);
        textViewQuestionFour = view.findViewById(R.id.test_page_one_question_four);
        textViewQuestionFive = view.findViewById(R.id.test_page_one_question_five);
        radioGroupAnswerOne = view.findViewById(R.id.test_page_one_choices_one);
        radioGroupAnswerTwo = view.findViewById(R.id.test_page_one_choices_two);
        radioGroupAnswerThree = view.findViewById(R.id.test_page_one_choices_three);
        radioGroupAnswerFour = view.findViewById(R.id.test_page_one_choices_four);
        radioGroupAnswerFive = view.findViewById(R.id.test_page_one_choices_five);
        scrollView = view.findViewById(R.id.test_page_one_scroll_layout);
        progressBar = view.findViewById(R.id.test_page_one_progress_bar);



    }
    public void animation(View view){
        YoYo.with(Techniques.FadeIn)
                .duration(1000)
                .playOn(view.findViewById(R.id.test_page_one_question_one_card_view));
        YoYo.with(Techniques.FadeIn)
                .duration(1100)
                .playOn(view.findViewById(R.id.test_page_one_question_two_card_view));
        YoYo.with(Techniques.FadeIn)
                .duration(1200)
                .playOn(view.findViewById(R.id.test_page_one_question_three_card_view));
        YoYo.with(Techniques.FadeIn)
                .duration(1300)
                .playOn(view.findViewById(R.id.test_page_one_question_four_card_view));
        YoYo.with(Techniques.FadeIn)
                .duration(1400)
                .playOn(view.findViewById(R.id.test_page_one_question_five_card_view));
    }

}