package com.example.course.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Cours {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long coursId;

        private String name;

        private String prof;
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();
    public Long getCoursId() {
        return coursId;
    }

    public void setCoursId(Long coursId) {
        this.coursId = coursId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
