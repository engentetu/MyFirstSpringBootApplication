package com.example.myfirstapplication.service;

import com.example.myfirstapplication.dao.SurveyDao;
import com.example.myfirstapplication.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyDao surveyDao;

    @Autowired
    public SurveyServiceImpl(SurveyDao surveyDao) {
        this.surveyDao = surveyDao;
    }

    @Override
    public void saveSurvey(Survey survey) {
        surveyDao.insertSurvey(survey);
    }

    @Override
    public List<Survey> getAll() {
        return surveyDao.getAll();
    }
}
