package com.example.myfirstapplication.app.survey;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class SurveyForm {

    @NotNull(message = "age: positive number value is required")
    @Min(value = 0, message = "age: positive number, min 18 is required")
    @Max(value = 150, message = "age: positive number, max 150 is required")
    private int age;

    @NotNull(message = "satisfaction: value is required")
    @Min(value = 1, message = "satisfaction: positive number, min 1 is required")
    @Max(value = 5, message = "satisfaction: positive number, max 5 is required")
    private int satisfaction;

    @NotNull
    @Size(min = 1, max = 200, message = "Please input 200 chars or less")
    private String comment;

    private LocalDateTime created;

    public SurveyForm() {
    }

//    public SurveyForm(Integer age, Integer satisfaction, String comment) {
//        this.age = age;
//        this.satisfaction = satisfaction;
//        this.comment = comment;
//    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
