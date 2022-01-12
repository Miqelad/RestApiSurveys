package com.survey.api.survey.service;

import com.survey.api.survey.entity.UserEntity;
import com.survey.api.survey.exception.UserAlreadyExist;
import com.survey.api.survey.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public UserEntity registation(UserEntity user) throws UserAlreadyExist {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            //если уже есть такой логин
            throw new UserAlreadyExist("Пользователь с таким именем уже существует");
        } else {
            return userRepo.save(user);
        }
    }

}
