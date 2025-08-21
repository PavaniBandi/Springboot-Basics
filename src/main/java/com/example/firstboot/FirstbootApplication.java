package com.example.firstboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstbootApplication.class, args);
    }

}

//controller->service->repository
/*
 * 
 * Book Model-> id,title,authorr, year; controller and service with placeholders
 */
