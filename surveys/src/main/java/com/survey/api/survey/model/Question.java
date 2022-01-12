package com.survey.api.survey.model;

import com.survey.api.survey.entity.SurveyQuestions;

public class Question {
    private int id;
    private String question;
    private String type;
    public static Question toModel(SurveyQuestions entity){
        Question model = new Question();
        model.setId(entity.getId());
        model.setType(entity.getType());
        model.setQuestion(entity.getQuestion());
        return model;
    }

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
