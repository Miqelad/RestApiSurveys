package com.survey.api.survey.repository;

import com.survey.api.survey.entity.SurveyEntity;
import org.springframework.data.repository.CrudRepository;

public interface SurveyRepo extends CrudRepository<SurveyEntity,Integer> {
}
