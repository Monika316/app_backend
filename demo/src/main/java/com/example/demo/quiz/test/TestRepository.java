package com.example.demo.quiz.test;

import com.example.demo.quiz.options.Options;
import com.example.demo.quiz.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {

}
