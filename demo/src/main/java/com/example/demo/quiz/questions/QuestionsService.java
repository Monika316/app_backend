package com.example.demo.quiz.questions;

import com.example.demo.quiz.test.Test;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class QuestionsService {
    private final QuestionRepository questionRepository;
    public void saveQuestion(Questions question, Test testId) {

        Questions newQuestion = new Questions(
                question.getQuestion(),
                question.getOptionA(),
                question.getOptionB(),
                question.getOptionC(),
                question.getOptionD(),
                question.getOptionE(),
                question.getOptionF(),
                question.getCorrectAns(),
                question.getTestIdStr(),
                testId
        );

        questionRepository.save(newQuestion);
    }
    public List<Questions> getQuestions(Long testId) {
        List<Questions> allQues = questionRepository.findByTestId(testId);
//        List<Questions> qList = new ArrayList<Questions>();
//
//        Random random = new Random();
//
//        for(int i=0; i<5; i++) {
//            int rand = random.nextInt(allQues.size());
//            qList.add(allQues.get(rand));
//            allQues.remove(rand);
//        }
        return allQues;
    }

}
