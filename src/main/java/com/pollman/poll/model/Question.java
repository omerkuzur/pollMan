package com.pollman.poll.model;

import jakarta.persistence.*;
import org.springframework.security.core.parameters.P;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

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


}
