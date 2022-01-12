package com.survey.api.survey.controller;

import com.survey.api.survey.entity.SurveyEntity;
import com.survey.api.survey.entity.UserEntity;
import com.survey.api.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SurveyController {
    @Autowired
    private SurveyService service;
    @PostMapping("/survey/create")
    public ResponseEntity creatSurvey(@RequestParam Integer ids, @RequestBody SurveyEntity survey){
        if(ids==1){
        service.createSurvey(survey);
        return ResponseEntity.ok("Опрос создан");}
        return ResponseEntity.ok("Зайдите под администратором");

    }
    @DeleteMapping("/survey/delete/{id}")
    public ResponseEntity deleteSurvey (@RequestParam Integer ids,@PathVariable Integer id ){
        if(ids==1){
        try{
            return ResponseEntity.ok(service.deleteSurvey(id));

        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }}
        return ResponseEntity.badRequest().body("Зайдите под администратором");

    }
    @PutMapping("/survey/update")
    public ResponseEntity updateSurvey(@RequestParam Integer ids,@RequestBody SurveyEntity survey ){
        if(ids==1
                && survey.getDatastart()==null
                && survey.getDataend() !=null
                && survey.getId()!=0
                && survey.getDescription()!=null){
            service.createSurvey(survey);
            return ResponseEntity.ok("Опрос изменен");
        }
        return ResponseEntity.badRequest().body("Ознакомьтесь с иснтрукцией");

    }


}
