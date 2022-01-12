package com.survey.api.survey.service;

import com.survey.api.survey.entity.SurveyEntity;
import com.survey.api.survey.entity.SurveyQuestions;
import com.survey.api.survey.model.Question;
import com.survey.api.survey.repository.QuestionRepo;
import com.survey.api.survey.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private SurveyRepo surveyRepo;
    public Question startSurvey(SurveyQuestions s, Integer surveyid){
        SurveyEntity surv=surveyRepo.findById(surveyid).get();
        s.setSurveys(surv);
        return Question.toModel(questionRepo.save(s));
    }
    public Integer deleteQuestion(Integer id){
        questionRepo.deleteById(id);
        return id;
    }

}
