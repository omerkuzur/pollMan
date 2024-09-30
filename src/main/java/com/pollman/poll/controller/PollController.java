package com.pollman.poll.controller;

import com.pollman.poll.model.Poll;
import com.pollman.poll.model.Question;
import com.pollman.poll.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class PollController {

    @Autowired
    private PollService pollService;


    // Ana sayfa için yönlendirme
    @GetMapping("/")
    public String index() {
        return "index"; // index.html
    }



    @GetMapping("/polls")
    public String getPolls(Model model) {
        List<Poll> polls = pollService.getAllPolls();
        model.addAttribute("polls", polls);
        return "polls";
    }

    @GetMapping("/polls/{pollId}")
    public String getPollDetails(@PathVariable Long pollId, Model model) {
        Poll poll = pollService.getPollById(pollId);
        model.addAttribute("poll", poll);
        return "pollDetails";
    }

    @PostMapping("/polls")
    public String createPoll(@ModelAttribute Poll poll) {
        pollService.createPoll(poll);
        return "redirect:/polls";
    }


    @PostMapping("/polls/{pollId}/vote")
    public String vote(@PathVariable Long pollId, @RequestParam Map<String, String> allParams) {
        Poll poll = pollService.getPollById(pollId);
        if (poll == null) {
            return "error"; // Eğer anket bulunamazsa
        }

        // Soruları döngü ile gezerek optionId'yi alalım
        for (Question question : poll.getQuestions()) {
            // Formda question_X formatında gelen parametreyi alıyoruz
            String optionIdStr = allParams.get("question_" + question.getId());

            // Eğer ilgili parametre varsa, optionId'yi alalım
            if (optionIdStr != null) {
                try {
                    Long optionId = Long.parseLong(optionIdStr); // String'i Long'a çeviriyoruz
                    pollService.vote(pollId, optionId);  // Oylamayı gerçekleştir
                } catch (NumberFormatException e) {
                    // Eğer Long'a çevrilemezse bir hata döndürebilirsiniz
                    System.out.println("Geçersiz seçenek ID'si: " + optionIdStr);
                    return "error";
                }
            }
        }
        return "redirect:/polls/" + pollId; // Oylama tamamlanınca yeniden anket sayfasına yönlendir
    }


    @GetMapping("/polls/new")
    public String createPollForm(Model model) {
        model.addAttribute("poll", new Poll());
        return "createPoll";
    }

    // Anket ekleme sayfası
    @GetMapping("/new")
    public String showCreatePollForm(Model model) {
        model.addAttribute("poll", new Poll());
        return "createPoll"; // createPoll.html
    }

    // Anketlere oy verme sayfası
    @GetMapping("/u")
    public String showPolls(Model model) {
        List<Poll> polls = pollService.getAllPolls();
        model.addAttribute("polls", polls);
        return "votePolls"; // votePolls.html
    }

    @GetMapping("/polls/results")
    public String showResults(Model model) {
        List<Poll> polls = pollService.getAllPolls();
        model.addAttribute("polls", polls);
        return "pollResults";
    }


}
