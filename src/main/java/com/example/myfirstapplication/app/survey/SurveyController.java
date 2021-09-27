package com.example.myfirstapplication.app.survey;

import com.example.myfirstapplication.entity.Survey;
import com.example.myfirstapplication.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/survey")
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping
    public String form(Model model){
        model.addAttribute("title", "Survey Index");
        model.addAttribute("surveyList", surveyService.getAll());
        return "survey/index";
    }

    @GetMapping("/form")
    public String form(SurveyForm surveyForm, Model model, @ModelAttribute("complete") String complete){
        model.addAttribute("title", "Survey Form");
        return "survey/form";
    }

    @PostMapping("/form")
    public String formPost(SurveyForm surveyForm, Model model){
        model.addAttribute("title", "Survey Form");
        return "survey/form";
    }


    @PostMapping("/confirm")
    public String confirm(@Validated SurveyForm surveyForm, BindingResult bindingResult,  Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Survey Form");
            return "survey/form";
        }

        model.addAttribute("title", "Survey Confirm Form");

        return "survey/confirm";
    }


    @PostMapping("/complete")
    public String complete(@Validated SurveyForm surveyForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Survey Form");
            return "survey/form";
        }

        Survey survey = new Survey();
        survey.setAge(surveyForm.getAge());
        survey.setSatisfaction(surveyForm.getSatisfaction());
        survey.setComment(surveyForm.getComment());
        survey.setCreated(LocalDateTime.now());

        surveyService.saveSurvey(survey);

        redirectAttributes.addFlashAttribute("complete", "OK!!");
        model.addAttribute("title", "Survey Form");

        return "redirect:/survey/form";
    }
}
