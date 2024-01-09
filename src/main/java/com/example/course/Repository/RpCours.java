package com.example.course.Repository;


import com.example.course.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RpCours extends JpaRepository<Cours, Long> {
    List<Cours> findByStudentsId(Long studentId);
}
