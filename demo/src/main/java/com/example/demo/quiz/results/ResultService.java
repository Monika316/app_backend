package com.example.demo.quiz.results;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;
    public void saveResult(Results result) {resultRepository.save(result);}
    public Optional<Results> getResult(Long userTestId) {return resultRepository.findByUserTestId(userTestId);}

}
