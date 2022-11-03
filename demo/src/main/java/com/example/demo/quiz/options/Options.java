package com.example.demo.quiz.options;

import com.example.demo.quiz.questions.Questions;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Options {
    @SequenceGenerator(
            name = "option_sequence",
            sequenceName = "option_sequence",
            allocationSize = 6
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "option_sequence"
    )
    private Long id;
    private String option;
    private Boolean ifTrue;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "questions_id"
    )
    private Questions question;

    public Options(String option, Boolean ifTrue, Questions question) {
        this.option = option;
        this.ifTrue = ifTrue;
        this.question = question;
    }
}
