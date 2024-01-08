package com.example.student.Controller;

import com.example.student.Repository.RpStudent;
import entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private RpStudent studentRepository;

    public List<Student> getStudentsByCourse(Long courseId) {
        return studentRepository.findByCoursesId(courseId);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}

