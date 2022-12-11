package com.example.demo.quiz.history;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UserTestService {
    private final UserTestRepository userTestRepository;
    public void saveUserTest(UserTest userTest) {
        userTestRepository.save(userTest);}

    public List<UserTest> getUserTest(Long appUserId) {
        List<UserTest> allTest = userTestRepository.findByAppUserId(appUserId);
        return allTest;
    }
}
