package com.example.firstboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //Get, put,post,delete - Rest Methods
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    //welcome/pavani ->Path Variables are not optional
    @GetMapping("/welcome/{username}")
    public String welcomeUser(@PathVariable String username) {
        return "welcome " + username;
    }

    //greet?name=pavani ->Optional
    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Welcome " + name;
    }

    // http://localhost:8080/wish?name=pavani&time=evening
    @GetMapping("/wish")
    public String wishString(@RequestParam String name, @RequestParam String time) {
        return "Good " + time + " " + name;
    }

    @GetMapping("/status")
    public Map<String, String> getMethodName() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Pavani");
        map.put("id", "12");
        return map;
    }

    /* 
    /wish  request param - name and timeofday 

    return Good Morning Pavani
    Good evening Pavani

    /status
    return Map
     */
}
