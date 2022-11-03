package com.example.demo.quiz.history;

import com.example.demo.quiz.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTestRepository extends JpaRepository<UserTest,Long> {
    List<UserTest> findByAppUserId(Long appUserId);
}
