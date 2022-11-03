package com.example.demo.quiz.test;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Test {
    @SequenceGenerator(
            name = "test_sequence",
            sequenceName = "test_sequence",
            allocationSize = 5
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "test_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String testName;
    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Test(String testName, LocalDateTime createdAt) {
        this.testName = testName;
        this.createdAt = createdAt;
    }
}
