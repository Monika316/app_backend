package com.example.demo.quiz;

import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserService;
import com.example.demo.quiz.history.UserTest;
import com.example.demo.quiz.history.UserTestService;
import com.example.demo.quiz.test.Test;
import com.example.demo.quiz.test.TestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private final UserTestService userTestService;
    @PostMapping(path = "/addTest")
    public void saveTest(@RequestBody Test test, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();

        String username = principal.getName();
        log.info(username);
        testService.saveTest(test, username);
    }

    @GetMapping(path = "/getTest")
    public List<Optional<Test>> getTest( HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();
        String username = principal.getName();
        log.info(username);
        Optional<AppUser> appUser=appUserService.getUser(username);
        return testService.getTestByAppUserId(appUser.get().getId());
    }
}
