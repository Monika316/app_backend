package com.example.demo.quiz.results;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResultRepository extends JpaRepository<Results,Long> {
    Optional<Results> findByUserTestId(Long userTestId);
}
