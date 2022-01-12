package com.survey.api.survey.controller;

import com.survey.api.survey.entity.UserEntity;
import com.survey.api.survey.exception.UserAlreadyExist;
import com.survey.api.survey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity start() {
        try {
            return ResponseEntity.ok("Сервер работает");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/registration")
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registation(user);
            return ResponseEntity.ok("Пользователь зарегистрирован, ваш ID: " + user.getId());
        } catch (UserAlreadyExist e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/who")
    public ResponseEntity whoIsUser(@RequestBody UserEntity user) {

        try {
            if (user.getId()==1){
                return ResponseEntity.ok("Вы Админ");
            }
            return ResponseEntity.ok("Вы пользователь");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }

    }
}
