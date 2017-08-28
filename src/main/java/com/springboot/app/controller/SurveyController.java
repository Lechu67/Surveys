package com.springboot.app.controller;

import com.springboot.app.model.Question;
import com.springboot.app.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    private SurveyService service;

    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> getQuestionsFromSurvey(@PathVariable String surveyId){
        return service.retrieveQuestions(surveyId);
    }
    @GetMapping("/surveys/{surveyId}/questions/{questionId}")
    public Question getQuestionFromQuestionsOfSurvey(@PathVariable String surveyId, @PathVariable String questionId){
        return service.retrieveQuestion(surveyId,questionId);
    }
}
