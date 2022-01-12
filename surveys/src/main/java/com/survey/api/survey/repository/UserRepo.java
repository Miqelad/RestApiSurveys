package com.survey.api.survey.repository;

import com.survey.api.survey.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
/*1-ый параметр сущность, 2-ой параметр тип его идентификатора */
public interface UserRepo extends CrudRepository<UserEntity,Integer> {
    UserEntity findByUsername(String username);//поиск пользователя

}
