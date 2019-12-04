package com.example.alibaba_sentinel_annotation.controller;

import com.example.alibaba_sentinel_annotation.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class HelloController {
    @Autowired
    private TestService testService;

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @RequestMapping("/hello")
    public String hello () {
        testService.doSomeThing("hello: " + LocalDateTime.now().format(dateTimeFormatter));
        return "hello";
    }

    @GetMapping("/hello2")
    public String hello2() {
        testService.doSomeThing2("hello2: " + LocalDateTime.now().format(dateTimeFormatter));
        return "hello2";
    }
}
