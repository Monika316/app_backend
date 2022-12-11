package com.example.demo.quiz.questions;

import com.example.demo.quiz.test.Test;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Optional;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Questions {
    @SequenceGenerator(
            name = "question_sequence",
            sequenceName = "question_sequence",
            allocationSize = 10
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "question_sequence"
    )
    private Long id;
    private String question;

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String optionE;
    private String optionF;
    private String correctAns;
    private String testIdStr;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "test_id"
    )
    private Test test;

    public Questions(String question, String optionA, String optionB, String optionC, String optionD, String optionE, String optionF, String correctAns, String testIdStr, Test test) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.optionE = optionE;
        this.optionF = optionF;
        this.correctAns = correctAns;
        this.testIdStr=testIdStr;
        this.test = test;
    }

    public Questions(String question, String optionA, String optionB, String optionC, String optionD, String optionE, String optionF, String correctAns, String testIdStr) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.optionE = optionE;
        this.optionF = optionF;
        this.correctAns = correctAns;
        this.testIdStr=testIdStr;
    }
    //    public Questions(String question, Test test) {
//        this.question = question;
//        this.test = test;
//    }
}
