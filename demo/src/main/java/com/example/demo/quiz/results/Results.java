package com.example.demo.quiz.results;

import com.example.demo.appuser.AppUser;
import com.example.demo.quiz.history.UserTest;
import com.example.demo.quiz.test.Test;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Results {
    @SequenceGenerator(
            name = "results_sequence",
            sequenceName = "results_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "results_sequence"
    )
    private Long id;
    private Integer score;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "user_test_id"
    )
    private UserTest userTest;



    public Results(Integer score, LocalDateTime date, UserTest userTest) {
        this.score = score;
        this.date = date;
        this.userTest = userTest;

    }
}
