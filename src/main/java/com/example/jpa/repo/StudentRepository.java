package com.example.jpa.repo;

import com.example.jpa.entity.Instructor;
import com.example.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByAdvisor(Instructor entity);
    List<Student> findAllByAdvisorId(Long id);
}
