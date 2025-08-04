package com.example.firstboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstboot.exception.StudentNotFoundException;
import com.example.firstboot.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

    private Map<Integer, Student> students = new HashMap<>();
    private int idCounter = 1;

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        student.setId(idCounter++);
        students.put(student.getId(), student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> studentidexcept(@PathVariable int id) {
        Student student = students.get(id);
        if (student == null) {
            throw new StudentNotFoundException("Student Not Found");
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("/check")
    public ResponseEntity<String> checkStatus(@RequestParam int code) {
        HttpStatus status = HttpStatus.resolve(code);
        if (status == null) {
            return ResponseEntity.badRequest().body("Invalid Code");
        } else {
            return ResponseEntity.ok("Valid Status" + status);
        }
    }

}

// HttpStatus.resolve(404) ->HttpStatus 
//Controller->Service->Repo
