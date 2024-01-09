package com.example.course.controllers;


import com.example.course.Repository.RpCours;
import com.example.course.entities.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursService {

    @Autowired
    private RpCours courseRepository;

    public List<Cours> getCoursesByStudent(Long studentId) {
        return courseRepository.findByStudentsId(studentId);
    }

    public List<Cours> getAllCourses() {
        return courseRepository.findAll();
    }
}

