package com.survey.api.survey.entity;

import javax.persistence.*;

/*Вопросы к опросам*/
@Entity
public class SurveyQuestions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String question;
    private String type;
    @ManyToOne
    @JoinColumn(name="survey_id")
    private SurveyEntity surveys;

    public SurveyQuestions() {
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

    public SurveyEntity getSurveys() {
        return surveys;
    }

    public void setSurveys(SurveyEntity surveys) {
        this.surveys = surveys;
    }
}
