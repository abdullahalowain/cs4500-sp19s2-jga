package com.example.cs4500sp19s2jga.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="frequently_asked_answers")
public class FrequentlyAskedAnswer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String answer;
    private FrequentlyAskedQuestion frequentlyAskedQuestion;
    public FrequentlyAskedQuestion getFrequentlyAskedQuestion() {
        return frequentlyAskedQuestion;
    }
    public void setFrequentlyAskedQuestion(FrequentlyAskedQuestion frequentlyAskedQuestion) {
        this.frequentlyAskedQuestion = frequentlyAskedQuestion;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
