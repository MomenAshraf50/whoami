package com.example.whoami.questions;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.whoami.R;
import com.example.whoami.ui.ResultActivity;
import com.example.whoami.api.Eight;
import com.example.whoami.api.QuestionsResponse;
import com.example.whoami.api.RetrofitClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QuestionsGroupEightFragment extends Fragment {
    String answerOne,answerTwo,answerThree,answerFour,answerFive;
    TextView textViewQuestionOne,textViewQuestionTwo,textViewQuestionThree,textViewQuestionFour
            ,textViewQuestionFive,textViewAnswerOne,textViewAnswerTwo,textViewAnswerThree,textViewAnswerFour,textViewAnswerFive;
    FloatingActionButton pageEightButton;
    SeekBar seekBarOne,seekBarTWo,seekBarThree,seekBarFour,seekBarFive;
    SharedPreferences sharedPreferences;

    List<String> answers  = new ArrayList<>();
    ScrollView scrollView;
    ProgressBar progressBar;
    private static final String TAG = "QuestionsGroupEightFrag";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions_group_eight, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inet(view);
        animation(view);
        seekBarChange();

        RetrofitClient.getService().getQuestions()
                .enqueue(new Callback<QuestionsResponse>() {
                    @Override
                    public void onResponse(Call<QuestionsResponse> call, Response<QuestionsResponse> response) {
                        if (response.isSuccessful()&&response.body() != null) {
                            QuestionsResponse questionsResponse = response.body();
                            List<Eight> fiveList = questionsResponse.get8();
                            Eight one = fiveList.get(0);
                            String questionOne = one.getQuestion();
                            Eight two = fiveList.get(1);
                            String questionTwo = two.getQuestion();
                            Eight three = fiveList.get(2);
                            String questionThree = three.getQuestion();
                            Eight four = fiveList.get(3);
                            String questionFour = four.getQuestion();
                            Eight five = fiveList.get(4);
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

                    }
                });

        pageEightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerOne = String.valueOf(seekBarOne.getProgress());
                answerTwo = String.valueOf(seekBarTWo.getProgress());
                answerThree = String.valueOf(seekBarThree.getProgress());
                answerFour = String.valueOf(seekBarFour.getProgress());
                answerFive = String.valueOf(seekBarFive.getProgress());
                if (answerOne.equals("0")|| answerTwo.equals("0")||answerThree.equals("0")|| answerFour.equals("0") ||answerFive.equals("0")){
                    Toast.makeText(getContext(), "Please, answer all Questions", Toast.LENGTH_SHORT).show();
                    if (answerOne.equals("0")){
                        YoYo.with(Techniques.Shake).duration(1000).playOn(view.findViewById(R.id.test_page_eight_question_one_card_view));
                    }
                    if (answerTwo.equals("0")){
                        YoYo.with(Techniques.Shake).duration(1000).playOn(view.findViewById(R.id.test_page_eight_question_two_card_view));
                    }
                    if (answerThree.equals("0")){
                        YoYo.with(Techniques.Shake).duration(1000).playOn(view.findViewById(R.id.test_page_eight_question_three_card_view));
                    }
                    if (answerFour.equals("0")){
                        YoYo.with(Techniques.Shake).duration(1000).playOn(view.findViewById(R.id.test_page_eight_question_four_card_view));
                    }
                    if (answerFive.equals("0")){
                        YoYo.with(Techniques.Shake).duration(1000).playOn(view.findViewById(R.id.test_page_eight_question_five_card_view));
                    }
                    return;
                }

                getData();

                RetrofitClient.getService().storePost(answers)
                        .enqueue(new Callback<Integer>() {
                            @Override
                            public void onResponse(Call<Integer> call, Response<Integer> response) {
                                Toast.makeText(getContext(), "sent", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getContext(),ResultActivity.class);
                                intent.putExtra("personalityNum",response.body());
                                startActivity(intent);
                                Log.i(TAG, "onResponse: "+response.body());
                            }

                            @Override
                            public void onFailure(Call<Integer> call, Throwable t) {
                                Log.i(TAG, "onFailure: "+t.getMessage());
                            }


                        });



                Toast.makeText(getContext(), "Good Job", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void inet(View view){
        pageEightButton = view.findViewById(R.id.test_page_eight_floating_btn);
        textViewQuestionOne = view.findViewById(R.id.test_page_eight_question_one);
        textViewQuestionTwo = view.findViewById(R.id.test_page_eight_question_two);
        textViewQuestionThree = view.findViewById(R.id.test_page_eight_question_three);
        textViewQuestionFour = view.findViewById(R.id.test_page_eight_question_four);
        textViewQuestionFive = view.findViewById(R.id.test_page_eight_question_five);
        seekBarOne = view.findViewById(R.id.test_page_eight_question_one_seek_bar);
        seekBarTWo = view.findViewById(R.id.test_page_eight_question_two_seek_bar);
        seekBarThree = view.findViewById(R.id.test_page_eight_question_three_seek_bar);
        seekBarFour = view.findViewById(R.id.test_page_eight_question_four_seek_bar);
        seekBarFive = view.findViewById(R.id.test_page_eight_question_five_seek_bar);
        textViewAnswerOne = view.findViewById(R.id.seek_bar_answer_one_tv);
        textViewAnswerTwo = view.findViewById(R.id.seek_bar_answer_two_tv);
        textViewAnswerThree = view.findViewById(R.id.seek_bar_answer_three_tv);
        textViewAnswerFour = view.findViewById(R.id.seek_bar_answer_four_tv);
        textViewAnswerFive = view.findViewById(R.id.seek_bar_answer_five_tv);
        scrollView = view.findViewById(R.id.test_page_eight_scroll_layout);
        progressBar = view.findViewById(R.id.test_page_eight_progress_bar);




    }
    public void animation(View view){
        YoYo.with(Techniques.FadeIn)
                .duration(1000)
                .playOn(view.findViewById(R.id.test_page_eight_question_one_card_view));
        YoYo.with(Techniques.FadeIn)
                .duration(1100)
                .playOn(view.findViewById(R.id.test_page_eight_question_two_card_view));
        YoYo.with(Techniques.FadeIn)
                .duration(1200)
                .playOn(view.findViewById(R.id.test_page_eight_question_three_card_view));
        YoYo.with(Techniques.FadeIn)
                .duration(1300)
                .playOn(view.findViewById(R.id.test_page_eight_question_four_card_view));
        YoYo.with(Techniques.FadeIn)
                .duration(1400)
                .playOn(view.findViewById(R.id.test_page_eight_question_five_card_view));
    }
    public void seekBarChange(){

        seekBarOne.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewAnswerOne.setText(String.valueOf(progress));


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarTWo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewAnswerTwo.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarThree.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewAnswerThree.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarFour.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewAnswerFour.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarFive.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewAnswerFive.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void getData(){
        sharedPreferences = Objects.requireNonNull(requireActivity()).getSharedPreferences("answers", Context.MODE_PRIVATE);
        String pageOneAnswerOne = sharedPreferences.getString("pageOneAnswerOne","null");
        String pageOneAnswerTwo = sharedPreferences.getString("pageOneAnswerTwo","null");
        String pageOneAnswerThree =sharedPreferences.getString("pageOneAnswerThree","null");
        String pageOneAnswerFour =sharedPreferences.getString("pageOneAnswerFour","null");
        String pageOneAnswerFive =sharedPreferences.getString("pageOneAnswerFive","null");
        String pageTwoAnswerOne = sharedPreferences.getString("pageTwoAnswerOne","null");
        String pageTwoAnswerTwo = sharedPreferences.getString("pageTwoAnswerTwo","null");
        String pageTwoAnswerThree =sharedPreferences.getString("pageTwoAnswerThree","null");
        String pageTwoAnswerFour =sharedPreferences.getString("pageTwoAnswerFour","null");
        String pageTwoAnswerFive =sharedPreferences.getString("pageTwoAnswerFive","null");
        String pageThreeAnswerOne = sharedPreferences.getString("pageThreeAnswerOne","null");
        String pageThreeAnswerTwo = sharedPreferences.getString("pageThreeAnswerTwo","null");
        String pageThreeAnswerThree =sharedPreferences.getString("pageThreeAnswerThree","null");
        String pageThreeAnswerFour =sharedPreferences.getString("pageThreeAnswerFour","null");
        String pageThreeAnswerFive =sharedPreferences.getString("pageThreeAnswerFive","null");
        String pageFourAnswerOne = sharedPreferences.getString("pageFourAnswerOne","null");
        String pageFourAnswerTwo = sharedPreferences.getString("pageFourAnswerTwo","null");
        String pageFourAnswerThree =sharedPreferences.getString("pageFourAnswerThree","null");
        String pageFourAnswerFour =sharedPreferences.getString("pageFourAnswerFour","null");
        String pageFourAnswerFive =sharedPreferences.getString("pageFourAnswerFive","null");
        String pageFiveAnswerOne = sharedPreferences.getString("pageFiveAnswerOne","null");
        String pageFiveAnswerTwo = sharedPreferences.getString("pageFiveAnswerTwo","null");
        String pageFiveAnswerThree =sharedPreferences.getString("pageFiveAnswerThree","null");
        String pageFiveAnswerFour =sharedPreferences.getString("pageFiveAnswerFour","null");
        String pageFiveAnswerFive =sharedPreferences.getString("pageFiveAnswerFive","null");
        String pageSixAnswerOne = sharedPreferences.getString("pageSixAnswerOne","null");
        String pageSixAnswerTwo = sharedPreferences.getString("pageSixAnswerTwo","null");
        String pageSixAnswerThree =sharedPreferences.getString("pageSixAnswerThree","null");
        String pageSixAnswerFour =sharedPreferences.getString("pageSixAnswerFour","null");
        String pageSixAnswerFive =sharedPreferences.getString("pageSixAnswerFive","null");
        String pageSevenAnswerOne = sharedPreferences.getString("pageSevenAnswerOne","null");
        String pageSevenAnswerTwo = sharedPreferences.getString("pageSevenAnswerTwo","null");
        String pageSevenAnswerThree =sharedPreferences.getString("pageSevenAnswerThree","null");
        String pageSevenAnswerFour =sharedPreferences.getString("pageSevenAnswerFour","null");
        String pageSevenAnswerFive =sharedPreferences.getString("pageSevenAnswerFive","null");
        String age = sharedPreferences.getString("age","null");

        answers.add(pageOneAnswerOne);
        answers.add(pageOneAnswerTwo);
        answers.add(pageOneAnswerThree);
        answers.add(pageOneAnswerFour);
        answers.add(pageOneAnswerFive);
        answers.add(pageTwoAnswerOne);
        answers.add(pageTwoAnswerTwo);
        answers.add(pageTwoAnswerThree);
        answers.add(pageTwoAnswerFour);
        answers.add(pageTwoAnswerFive);
        answers.add(pageThreeAnswerOne);
        answers.add(pageThreeAnswerTwo);
        answers.add(pageThreeAnswerThree);
        answers.add(pageThreeAnswerFour);
        answers.add(pageThreeAnswerFive);
        answers.add(pageFourAnswerOne);
        answers.add(pageFourAnswerTwo);
        answers.add(pageFourAnswerThree);
        answers.add(pageFourAnswerFour);
        answers.add(pageFourAnswerFive);
        answers.add(pageFiveAnswerOne);
        answers.add(pageFiveAnswerTwo);
        answers.add(pageFiveAnswerThree);
        answers.add(pageFiveAnswerFour);
        answers.add(pageFiveAnswerFive);
        answers.add(pageSixAnswerOne);
        answers.add(pageSixAnswerTwo);
        answers.add(pageSixAnswerThree);
        answers.add(pageSixAnswerFour);
        answers.add(pageSixAnswerFive);
        answers.add(pageSevenAnswerOne);
        answers.add(pageSevenAnswerTwo);
        answers.add(pageSevenAnswerThree);
        answers.add(pageSevenAnswerFour);
        answers.add(pageSevenAnswerFive);
        answers.add(answerOne);
        answers.add(answerTwo);
        answers.add(answerThree);
        answers.add(answerFour);
        answers.add(answerFive);
        answers.add(age);





    }
}