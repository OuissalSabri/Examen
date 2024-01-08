package com.example.student.Repository;

import entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RpStudent extends JpaRepository<Student, Long> {
    List<Student> findByCoursesId(Long courseId);
}

