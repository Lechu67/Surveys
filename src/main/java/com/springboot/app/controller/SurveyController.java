package com.springboot.app.controller;

import com.springboot.app.model.Question;
import com.springboot.app.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @PostMapping("/surveys/{surveyId}/questions")
    public ResponseEntity<?> addQuestionToSurvey(@PathVariable String surveyId, @RequestBody Question newQuestion){
        //adding the question, getting the new id
        Question question = service.addQuestion(surveyId,newQuestion);
        if (question == null) {
            return ResponseEntity.noContent().build();
        }
        //replacing the id in uri by the new one - creating location
        //URI  /surveys/{surveyId}/questions/{questionId} question.getId()
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(question.getId()).toUri();
        //returning a creation status back
        return ResponseEntity.created(uri).build();
    }
}
