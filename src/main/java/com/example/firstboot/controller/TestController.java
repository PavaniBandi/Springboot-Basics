package com.example.firstboot.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // private final CourseController courseController;
    // TestController(CourseController courseController) {
    //     this.courseController = courseController;
    // }
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // @GetMapping("/test")
    // @ResponseBody
    // public String sayTest() {
    //     return "Test";
    //     /*
    //      * 1 num1 num2
    //      * 2 num1/num2 //exception
    //      * 3 imp logic
    //      */
    // }
    @GetMapping("/public/password")
    public String encode(@RequestParam String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

}

//RestController = Controller+ ResponseBody
