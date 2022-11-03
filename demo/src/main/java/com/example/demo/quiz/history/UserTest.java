package com.example.demo.quiz.history;

import com.example.demo.appuser.AppUser;
import com.example.demo.quiz.test.Test;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserTest {
    @SequenceGenerator(
            name = "user_test_sequence",
            sequenceName = "user_test_sequence",
            allocationSize = 5
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_test_sequence"
    )
    private Long id;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private AppUser appUser;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "test_id"
    )
    private Test test;

    public UserTest(AppUser appUser, Test test) {
        this.appUser = appUser;
        this.test = test;
    }
}
