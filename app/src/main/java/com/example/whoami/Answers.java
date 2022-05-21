package com.example.whoami;

import java.util.ArrayList;
import java.util.List;

public class Answers{
    String questionId,questionAnswer;
    List<Answers> answers =new ArrayList<>();

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public Answers(String questionAnswer,String questionId) {
        this.questionId = questionId;
        this.questionAnswer = questionAnswer;
    }
}
