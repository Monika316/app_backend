package com.example.demo.quiz.options;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<Options,Long> {
    List<Options> findByQuestionId(Long questionId);
}
