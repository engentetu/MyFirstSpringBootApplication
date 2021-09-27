package com.example.myfirstapplication.dao;

import com.example.myfirstapplication.entity.Inquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class InquiryDaoImpl implements InquiryDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InquiryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertInquiry(Inquiry inquiry) {
        jdbcTemplate.update("INSERT INTO inquiry(name, email, contents, created) VALUES (?, ?, ?, ?)",
                inquiry.getName(), inquiry.getEmail(), inquiry.getContents(), inquiry.getCreated());

    }

    @Override
    public List<Inquiry> getAll() {
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList("SELECT id, name, email, contents, created FROM inquiry");

        List<Inquiry> list = new ArrayList<>();

        for (var result : resultList) {
            Inquiry inquiry = new Inquiry();
            inquiry.setId((int) result.get("id"));
            inquiry.setName((String) result.get("name"));
            inquiry.setEmail((String) result.get("email"));
            inquiry.setContents((String) result.get("contents"));
            inquiry.setCreated(((Timestamp) result.get("created")).toLocalDateTime());
            list.add(inquiry);
        }

        return list;
    }

    @Override
    public int updateInquiry(Inquiry inquiry) {
        return jdbcTemplate.update("UPDATE inquiry SET name= ?, email= ?, contents=? WHERE id= ?",
                inquiry.getName(), inquiry.getEmail(), inquiry.getContents(), inquiry.getId());
    }
}
