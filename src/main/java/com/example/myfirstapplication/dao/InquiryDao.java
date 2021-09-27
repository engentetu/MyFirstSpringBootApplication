package com.example.myfirstapplication.dao;

import com.example.myfirstapplication.entity.Inquiry;

import java.util.List;

public interface InquiryDao {

    void insertInquiry(Inquiry inquiry);

    List<Inquiry> getAll();

    int updateInquiry(Inquiry inquiry);
}
