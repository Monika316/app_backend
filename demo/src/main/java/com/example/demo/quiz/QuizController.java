package com.example.demo.quiz;

import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserService;
import com.example.demo.quiz.questions.Questions;
import com.example.demo.quiz.questions.QuestionsService;
import com.example.demo.quiz.test.Test;
import com.example.demo.quiz.test.TestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
@AllArgsConstructor
@Slf4j
public class QuizController {
    private final TestService testService;
    private final AppUserService appUserService;
    private final QuestionsService questionsService;
    @PostMapping(path = "/addTest")
    public Long saveTest(@RequestBody Test test, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        String username = principal.getName();
        log.info(username);
        return testService.saveTest(test, username);
    }

    @GetMapping(path = "/getTest")
    public List<Optional<Test>> getTest( HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();
        String username = principal.getName();
        log.info(username);
        Optional<AppUser> appUser=appUserService.getUser(username);
        return testService.getTestByAppUserId(appUser.get().getId());
    }

    @PostMapping(path = "addQuestions")
    public void saveQuestions(@RequestBody Questions questions) {
        String testId = questions.getTestIdStr();
        Long testIdNew = Long.parseLong(testId);
        Optional<Test> test= testService.getTest(testIdNew);
        questionsService.saveQuestion(questions, test.get());

    }

    @GetMapping(path = "getQuestions")
    public List<Questions> getQuestions(@RequestParam String testId) {
        Long testIdNew = Long.parseLong(testId);
        return questionsService.getQuestions(testIdNew);
    }
}
