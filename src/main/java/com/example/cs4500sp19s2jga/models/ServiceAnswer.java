package com.example.cs4500sp19s2jga.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="service_answers")
public class ServiceAnswer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private Boolean trueFalseAnswer;
    private Integer maxRangeAnswer;
    private Integer minRangeAnswer;
    private Integer choiceAnswer;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Boolean getTrueFalseAnswer() {
        return trueFalseAnswer;
    }
    public void setTrueFalseAnswer(Boolean trueFalseAnswer) {
        this.trueFalseAnswer = trueFalseAnswer;
    }
    public Integer getMaxRangeAnswer() {
        return maxRangeAnswer;
    }
    public void setMaxRangeAnswer(Integer maxRangeAnswer) {
        this.maxRangeAnswer = maxRangeAnswer;
    }
    public Integer getMinRangeAnswer() {
        return minRangeAnswer;
    }
    public void setMinRangeAnswer(Integer minRangeAnswer) {
        this.minRangeAnswer = minRangeAnswer;
    }
    public Integer getChoiceAnswer() {
        return choiceAnswer;
    }
    public void setChoiceAnswer(Integer choiceAnswer) {
        this.choiceAnswer = choiceAnswer;
    }
}
