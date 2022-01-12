package com.survey.api.survey.entity;
import javax.persistence.*;
import java.util.List;


@Entity
public class SurveyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "datastart", columnDefinition = "datetime(6)")
    private String datastart;
    @Column(name = "dataend", columnDefinition = "datetime(6)")
    private String dataend;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "surveys")
    private List<SurveyQuestions> todos;

    public SurveyEntity() {
    }

    public List<SurveyQuestions> getTodos() {
        return todos;
    }

    public void setTodos(List<SurveyQuestions> todos) {
        this.todos = todos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatastart() {
        return datastart;
    }

    public void setDatastart(String datastart) {
        this.datastart = datastart;
    }

    public String getDataend() {
        return dataend;
    }

    public void setDataend(String dataend) {
        this.dataend = dataend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}