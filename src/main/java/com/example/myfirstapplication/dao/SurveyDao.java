package com.example.myfirstapplication.dao;

import com.example.myfirstapplication.entity.Survey;

import java.util.List;

public interface SurveyDao {
    void insertSurvey(Survey survey);
    List<Survey> getAll();
}
