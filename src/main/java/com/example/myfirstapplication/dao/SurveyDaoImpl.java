package com.example.myfirstapplication.dao;

import com.example.myfirstapplication.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SurveyDaoImpl implements SurveyDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SurveyDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertSurvey(Survey survey) {
        jdbcTemplate.update("INSERT INTO survey(age, satisfaction, comment, created) VALUES(?, ?, ?, ?)",
                survey.getAge(), survey.getSatisfaction(), survey.getComment(), LocalDateTime.now());
    }

    @Override
    public List<Survey> getAll() {

        List<Survey> surveyList = new ArrayList<>();

        List<Map<String, Object>> resultList = jdbcTemplate.queryForList("SELECT id, age, satisfaction, comment, created FROM survey");


        for (var result : resultList) {
            Survey survey = new Survey();
            survey.setId((int) result.get("id"));
            survey.setAge((int) result.get("age"));
            survey.setSatisfaction((int) result.get("satisfaction"));
            survey.setComment((String) result.get("comment"));
            survey.setCreated(((Timestamp) result.get("created")).toLocalDateTime());

            surveyList.add(survey);
        }

        return surveyList;
    }
}
