package com.example.myfirstapplication.service;

import com.example.myfirstapplication.dao.InquiryDao;
import com.example.myfirstapplication.entity.Inquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InquiryServiceImpl implements InquiryService {


    private final InquiryDao inquiryDao;

    @Autowired
    public InquiryServiceImpl(InquiryDao inquiryDao) {
        this.inquiryDao = inquiryDao;
    }

    @Override
    public void save(Inquiry inquiry) {
        inquiryDao.insertInquiry(inquiry);
    }

    @Override
    public List<Inquiry> getAll() {
        return inquiryDao.getAll();
    }

    @Override
    public void update(Inquiry inquiry) {
        if(inquiryDao.updateInquiry(inquiry) == 0){
            throw new InquiryNotFoundException("Can not find the same ID");
        }
    }
}
