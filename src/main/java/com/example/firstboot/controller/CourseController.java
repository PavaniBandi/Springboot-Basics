package com.example.firstboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstboot.exception.CourseNotFoundException;
import com.example.firstboot.model.ApiResponse;
import com.example.firstboot.model.Course;

@RestController
@RequestMapping("/course")
public class CourseController {

    private Map<Integer, Course> courses = new HashMap<>();

    private int idCounter = 1;

    // GET /course/{id}
    @GetMapping("/{id}")
    public String getCourse(@PathVariable int id) {
        Course course = courses.get(id);
        return course != null ? course.getName() + course.getId() : "Course Not Found";
    }

    // POST /course?name=Java
    @PostMapping
    public String createCourse(@RequestParam String name) {
        courses.put(idCounter, new Course(idCounter, name));
        // idCounter++;// idCounter = idCounter+1
        return "Course created: " + name + " " + idCounter++;
    }

    // PUT /course/{id}?name=Spring
    @PutMapping("/{id}")
    public String updateCourse(@PathVariable int id, @RequestParam String name) {
        if (courses.containsKey(id)) {
            courses.put(id, new Course(id, name));
            return " Course Updated";
        }
        return "Course Not Found";
    }

    // DELETE /course/{id}
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable int id) {
        if (courses.remove(id) != null) {
            return "Course ID " + id + " deleted";
        } else {
            return "Course Not Found";
        }
    }

    // POST /course/create (with @RequestBody)
    @PostMapping("/create")
    public String createCourseBody(@RequestBody Course course) {
        if (course.getName() == null || course.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Course Name cannot be empty");
        }
        course.setId(idCounter);
        courses.put(idCounter++, course);
        return "Course created with ID: " + course.getId() + ", Name: " + course.getName();
    }

    @PostMapping("/createCourse")
    public ResponseEntity<ApiResponse<Course>> createCourseBodyT(@RequestBody Course course) {
        course.setId(idCounter);
        courses.put(idCounter++, course);
        ApiResponse<Course> response = new ApiResponse<Course>("Course Created", course);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
        // return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getCourse/{id}")
    public ResponseEntity<Course> getMethodName(@PathVariable int id) {
        Course course = courses.get(id);
        if (course == null) {
            throw new CourseNotFoundException("Course Not Found");
        }
        return ResponseEntity.ok(course);
    }

    /* 1. Throw IllegalArgexception in case of createcourse name empty or null
     * 2. StudentController id,name,Course -> create accept Requestbody
     * 3. getStudents if id not found throw custom exception
     */
}
