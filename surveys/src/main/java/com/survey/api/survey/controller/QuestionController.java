package com.survey.api.survey.controller;

import com.survey.api.survey.entity.SurveyEntity;
import com.survey.api.survey.entity.SurveyQuestions;
import com.survey.api.survey.model.Question;
import com.survey.api.survey.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity createQuestion(@RequestParam Integer ids, @RequestBody SurveyQuestions question,
                                         @RequestParam Integer id) {
        if (ids == 1) {
            return ResponseEntity.ok(questionService.startSurvey(question, id));

        }
        return ResponseEntity.badRequest().body("произошла ошибка");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteQuestion(@RequestParam Integer ids, @PathVariable Integer id) {
        if (ids == 1) {
            return ResponseEntity.ok(questionService.deleteQuestion(id));
        }
        return ResponseEntity.badRequest().body("произошла ошибка");
    }
    @PutMapping("/update")
    public ResponseEntity updateSurvey(@RequestParam Integer ids,@RequestBody SurveyQuestions question ){
        if(ids==1
        && question.getQuestion()!=null
        && question.getId()!=0
        && question.getType()!=null){
            questionService.startSurvey(question,question.getId());
            return ResponseEntity.ok("Вопрос изменен");
        }
        return ResponseEntity.badRequest().body("Ознакомьтесь с иснтрукцией");

    }
}
