package com.example.whoami.questions;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.whoami.R;
import com.example.whoami.api.One;
import com.example.whoami.api.QuestionsResponse;
import com.example.whoami.api.RetrofitClient;
import com.example.whoami.api.Seven;
import com.example.whoami.api.Six;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QuestionsGroupSevenFragment extends Fragment {
    RadioGroup radioGroupAnswerOne,radioGroupAnswerTwo,radioGroupAnswerThree,radioGroupAnswerFour
            ,radioGroupAnswerFive;
    RadioButton radioButtonAnswerOne,radioButtonAnswerTwo,radioButtonAnswerThree,radioButtonAnswerFour
            ,radioButtonAnswerFive;
    String answerOne,answerTwo,answerThree,answerFour,answerFive;
    FloatingActionButton pageSevenButton;
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

        inet(view);
        animation(view);


        RetrofitClient.getService().getQuestions()
                .enqueue(new Callback<QuestionsResponse>() {
                    @Override
                    public void onResponse(Call<QuestionsResponse> call, Response<QuestionsResponse> response) {
                        if (response.isSuccessful()&&response.body()!=null){
                            QuestionsResponse questionsResponse = response.body();
                            List<Seven> sevenList =questionsResponse.get7();
                            Seven one = sevenList.get(0);
                            String questionOne = one.getQuestion();
                            int questionIdOne = one.getId();
                            Seven two = sevenList.get(1);
                            String questionTwo = two.getQuestion();
                            int questionIdTwo = two.getId();
                            Seven three = sevenList.get(2);
                            int questionIdThree = three.getId();
                            String questionThree = three.getQuestion();
                            Seven four = sevenList.get(3);
                            int questionIdFour = four.getId();
                            String questionFour = four.getQuestion();
                            Seven five = sevenList.get(4);
                            int questionIdFive = five.getId();
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
        pageSevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int answerOneId = radioGroupAnswerOne.getCheckedRadioButtonId();
                int answerTwoId = radioGroupAnswerTwo.getCheckedRadioButtonId();
                int answerThreeId = radioGroupAnswerThree.getCheckedRadioButtonId();
                int answerFourId = radioGroupAnswerFour.getCheckedRadioButtonId();
                int answerFiveId = radioGroupAnswerFive.getCheckedRadioButtonId();

                if (answerOneId==-1||answerTwoId==-1||answerThreeId==-1||answerFourId==-1
                        ||answerFiveId==-1){
                    Toast.makeText(getContext(), "Please, answer all Questions", Toast.LENGTH_LONG).show();
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

                Toast.makeText(getContext(), "Good Job", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void inet(View view){
        pageSevenButton = view.findViewById(R.id.test_page_seven_floating_btn);
        textViewQuestionOne = view.findViewById(R.id.test_page_seven_question_one);
        textViewQuestionTwo = view.findViewById(R.id.test_page_seven_question_two);
        textViewQuestionThree = view.findViewById(R.id.test_page_seven_question_three);
        textViewQuestionFour = view.findViewById(R.id.test_page_seven_question_four);
        textViewQuestionFive = view.findViewById(R.id.test_page_seven_question_five);
        radioGroupAnswerOne = view.findViewById(R.id.test_page_seven_choices_one);
        radioGroupAnswerTwo = view.findViewById(R.id.test_page_seven_choices_two);
        radioGroupAnswerThree = view.findViewById(R.id.test_page_seven_choices_three);
        radioGroupAnswerFour = view.findViewById(R.id.test_page_seven_choices_four);
        radioGroupAnswerFive = view.findViewById(R.id.test_page_seven_choices_five);



    }
    public void animation(View view){
        YoYo.with(Techniques.FadeIn)
                .duration(1000)
                .playOn(view.findViewById(R.id.test_page_seven_question_one_card_view));
        YoYo.with(Techniques.FadeIn)
                .duration(1100)
                .playOn(view.findViewById(R.id.test_page_seven_question_two_card_view));
        YoYo.with(Techniques.FadeIn)
                .duration(1200)
                .playOn(view.findViewById(R.id.test_page_seven_question_three_card_view));
        YoYo.with(Techniques.FadeIn)
                .duration(1300)
                .playOn(view.findViewById(R.id.test_page_seven_question_four_card_view));
        YoYo.with(Techniques.FadeIn)
                .duration(1400)
                .playOn(view.findViewById(R.id.test_page_seven_question_five_card_view));
    }

}