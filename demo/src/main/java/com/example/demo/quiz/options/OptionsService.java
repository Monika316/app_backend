package com.example.demo.quiz.options;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OptionsService {
    private final OptionRepository optionRepository;
    public void saveOption(Options option) {optionRepository.save(option);}
    public List<Options> getOption(Long questionId) {
        List<Options> allOptions = optionRepository.findByQuestionId(questionId);
        return allOptions;
    }


}
