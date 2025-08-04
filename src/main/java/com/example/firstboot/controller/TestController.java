package com.example.firstboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    private final CourseController courseController;

    TestController(CourseController courseController) {
        this.courseController = courseController;
    }

    @GetMapping("/test")
    @ResponseBody
    public String sayTest() {
        return "Test";

        /*
         * 1 num1 num2
         * 2 num1/num2 //exception
         * 3 imp logic
         */
    }

}

//RestController = Controller+ ResponseBody
