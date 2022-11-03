package com.example.demo.quiz.questions;

import com.example.demo.quiz.questions.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Questions, Long> {
    List<Questions> findByTestId(Long TestId);
}
