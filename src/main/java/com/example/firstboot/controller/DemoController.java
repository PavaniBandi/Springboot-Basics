package com.example.firstboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello from Public API";
    }

    @GetMapping("/secure/hello")
    public String secureHello() {
        return "Hello from Secure API";
    }

    @GetMapping("/secure/admin/hello")
    public String secureAdmin() {
        return "Hello from Secure Admin API";
    }

    @GetMapping("/secure/user/hello")
    public String secureUser() {
        return "Hello from Secure User API";
    }
}
