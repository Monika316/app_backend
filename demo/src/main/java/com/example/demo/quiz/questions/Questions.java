package com.example.demo.quiz.questions;

import com.example.demo.quiz.test.Test;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "test_id"
    )
    private Test test;

    public Questions(String question, Test test) {
        this.question = question;
        this.test = test;
    }
}
