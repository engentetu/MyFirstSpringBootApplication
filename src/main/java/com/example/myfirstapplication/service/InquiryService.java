package com.example.myfirstapplication.service;

import com.example.myfirstapplication.entity.Inquiry;

import java.util.List;

public interface InquiryService {

    void save(Inquiry inquiry);

    void update(Inquiry inquiry);

    List<Inquiry> getAll();
}
