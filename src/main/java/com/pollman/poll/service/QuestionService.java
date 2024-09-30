package com.pollman.poll.service;

import com.pollman.poll.model.Question;
import com.pollman.poll.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getQuestionsByPollId(Long pollId){
        return questionRepository.findAll();
    }

    public Question addQuestion(Question question){
        return questionRepository.save(question);
    }



}
