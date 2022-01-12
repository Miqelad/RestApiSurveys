package com.survey.api.survey.service;

import com.survey.api.survey.entity.SurveyEntity;
import com.survey.api.survey.model.Survey;
import com.survey.api.survey.repository.SurveyRepo;
import com.survey.api.survey.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SurveyService {
    @Autowired
    private SurveyRepo surveyRepo;
    @Autowired
    private UserRepo userRepo;
    public SurveyEntity createSurvey(SurveyEntity survey){
        return surveyRepo.save(survey);
    }

    public Integer deleteSurvey(Integer id){
         surveyRepo.deleteById(id);
         return id;
    }




}
