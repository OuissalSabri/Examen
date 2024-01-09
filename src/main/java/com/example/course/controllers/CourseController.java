package com.example.course.controllers;


import com.example.course.Repository.RpCours;
import com.example.course.entities.Cours;
import com.example.course.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private RpCours courseRepository;

@Autowired
private CoursService coursService;
    private RestTemplate restTemplate;

    @GetMapping("/get_cours")
    public List<Cours> getAllCourses() {

        return courseRepository.findAll();
    }

    @GetMapping("/courses/student/{studentId}")
    public List<Cours> getCoursesByStudent(@PathVariable Long studentId) {

        return coursService.getCoursesByStudent(studentId);
    }

    private final String studentServiceUrl = "http://Student/get_student";

    @GetMapping("/{coursId}/students")
    public List<Student> getCourseStudents(@PathVariable Long coursId) {
        // Call the student-service to get students for a course
        ResponseEntity<List<Student>> response = restTemplate.exchange(
                studentServiceUrl + "/students/course/{coursId}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Student>>() {},
                coursId
        );

        return response.getBody();
    }


}

