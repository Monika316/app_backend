package com.example.demo.quiz.test;

import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserService;
import com.example.demo.quiz.history.UserTest;
import com.example.demo.quiz.history.UserTestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class TestService {
    private final TestRepository testRepository;
    private final AppUserService appUserService;
    private final UserTestService userTestService;

    public Long saveTest(Test test, String username) {
        Test newTest = new Test(
                test.getTestName(),
                LocalDateTime.now()
        );
        testRepository.save(newTest);

        Optional<AppUser> appUser=appUserService.getUser(username);
        UserTest userTest = new UserTest(appUser.get(), newTest);
        userTestService.saveUserTest(userTest);
        log.info(String.valueOf(newTest.getId()));
        return newTest.getId();
    }
    public List<Optional<Test>> getTestByAppUserId (Long appUserId) {
        List<UserTest> allUserTest = userTestService.getUserTest(appUserId);
        List<Optional<Test>> testList = new ArrayList<Optional<Test>>();
        for (UserTest test: allUserTest) {
            Long testId = test.getTest().getId();
            testList.add(getTest(testId));
        }
        log.info(String.valueOf(testList));
        return testList;
    }
    public Optional<Test> getTest(Long id) {
        return testRepository.findById(id);
    }
    
}
