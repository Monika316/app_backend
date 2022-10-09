package com.example.demo.demo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/demo")
@AllArgsConstructor
public class DemoController {
    @GetMapping
    public String confirm () {
        return "success";
    }
}
