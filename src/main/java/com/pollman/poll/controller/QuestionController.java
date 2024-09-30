package com.pollman.poll.controller;

import com.pollman.poll.model.Question;
import com.pollman.poll.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    private ResponseEntity<Question> addQuestion(@RequestBody Question question){
        Question createsQuestion = questionService.addQuestion(question);
        return ResponseEntity.ok(createsQuestion);
    }

    private ResponseEntity<List<Question>> getWuestionsByPollId(@PathVariable Long pollId){
        List<Question> questions = questionService.getQuestionsByPollId(pollId);
        return ResponseEntity.ok(questions);
    }

}
