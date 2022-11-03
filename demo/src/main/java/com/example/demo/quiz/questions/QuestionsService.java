package com.example.demo.quiz.questions;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class QuestionsService {
    private final QuestionRepository questionRepository;
    public void saveQuestion(Questions question) {questionRepository.save(question);}
    public List<Questions> getQuestions(Long testId) {
        List<Questions> allQues = questionRepository.findByTestId(testId);
        List<Questions> qList = new ArrayList<Questions>();

        Random random = new Random();

        for(int i=0; i<5; i++) {
            int rand = random.nextInt(allQues.size());
            qList.add(allQues.get(rand));
            allQues.remove(rand);
        }
        return qList;
    }

}
