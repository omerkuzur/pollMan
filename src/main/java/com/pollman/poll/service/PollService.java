package com.pollman.poll.service;

import com.pollman.poll.model.Option;
import com.pollman.poll.model.Poll;
import com.pollman.poll.model.Question;
import com.pollman.poll.repository.OptionRepository;
import com.pollman.poll.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private OptionRepository optionRepository;

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Poll getPollById(Long pollId) {
        Optional<Poll> poll = pollRepository.findById(pollId);
        return poll.orElse(null);
    }

    public void createPoll(Poll poll) {
        // Anket, sorular ve seçenekleri birlikte kaydedilir
        for (Question question : poll.getQuestions()) {
            question.setPoll(poll);
            for (Option option : question.getOptions()) {
                option.setQuestion(question);
            }
        }
        pollRepository.save(poll); // Sorular ve seçeneklerle birlikte kaydedilir
    }

    public void vote(Long pollId, Long optionId) {
        Optional<Option> option = optionRepository.findById(optionId);
        if (option.isPresent()) {
            Option opt = option.get();
            opt.setVoteCount(opt.getVoteCount() + 1);  // Oyu artır
            optionRepository.save(opt);  // Güncellenen oyu kaydet
        }
    }


}

