package com.survey.api.survey.entity;

import javax.persistence.*;
import java.util.List;

@Entity
    public class UserEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String username;
        private String password;
        @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
        private List<SurveyEntity> surv;

    public UserEntity() {
    }

    public UserEntity(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public List<SurveyEntity> getUsers() {
        return surv;
    }

    public void setUsers(List<SurveyEntity> users) {
        this.surv = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


