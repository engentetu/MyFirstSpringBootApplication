package com.example.myfirstapplication.config;


import com.example.myfirstapplication.service.InquiryNotFoundException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;


/*
*  すべてのControllerで共通処理を定義
* */
@ControllerAdvice
public class WebMvcControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public String handleException(EmptyResultDataAccessException emptyResultDataAccessException, Model model){
        model.addAttribute("message", emptyResultDataAccessException);
        return "error/error";
    }

    @ExceptionHandler(InquiryNotFoundException.class)
    public String handleException(InquiryNotFoundException inquiryNotFoundException, Model model){
        model.addAttribute("message", inquiryNotFoundException);
        return "error/error";
    }
}
