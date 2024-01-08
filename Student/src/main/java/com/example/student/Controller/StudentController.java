package com.example.student.Controller;

import com.example.student.Repository.RpStudent;
import entities.Cours;
import entities.Student;
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
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private RpStudent studentRepository;
     @Autowired
    private StudentService studentService;

    private RestTemplate restTemplate;
    @GetMapping("/get_student")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/course/{coursId}")
    public List<Student> getStudentsByCourse(@PathVariable Long coursId) {
        return studentService.getStudentsByCourse(coursId);

    }

    private final String courseServiceUrl = "http://Cours/get_cours";

    @GetMapping("/{studentId}/courses")
    public List<Cours> getStudentCourses(@PathVariable Long studentId) {

        ResponseEntity<List<Cours>> response = restTemplate.exchange(
                courseServiceUrl + "/courses/student/{studentId}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Cours>>() {},
                studentId
        );

        return response.getBody();
    }


}

