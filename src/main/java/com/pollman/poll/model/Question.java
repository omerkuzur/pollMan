package com.pollman.poll.model;

import jakarta.persistence.*;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Option> options;

    public Question(){}

    public Question(String text, Poll poll){
        this.text = text;
        this.poll = poll;
    }

    public  Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public Poll getPoll(){
        return poll;
    }

    public void setPoll(Poll poll){
        this.poll = poll;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

}
