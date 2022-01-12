package com.survey.api.survey.repository;

import com.survey.api.survey.entity.SurveyEntity;
import com.survey.api.survey.entity.SurveyQuestions;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepo extends CrudRepository<SurveyQuestions,Integer> {
}
