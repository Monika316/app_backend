package com.example.demo.quiz.history;

import com.example.demo.quiz.test.Test;
import com.example.demo.quiz.test.TestService;
import jdk.jfr.Label;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserTestService {
    private final UserTestRepository userTestRepository;
    //private final TestService testService;
    //List<Optional<Test>> testList = new ArrayList<Optional<Test>>();
    public void saveUserTest(UserTest userTest) {
        userTestRepository.save(userTest);}

    public List<UserTest> getUserTest(Long appUserId) {
        List<UserTest> allTest = userTestRepository.findByAppUserId(appUserId);
//        for (UserTest test: allTest) {
//            Long testId = test.getId();
//            testList.add(testService.getTest(testId));
//
//        }
        return allTest;
    }
//    public UserTest createUserTestConnection(AppUser appUser, Test test) {
//
//    }
}
