package com.example.jpa;

import com.example.jpa.entity.Student;
import com.example.jpa.repo.InstructorRepository;
import com.example.jpa.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;

    public StudentService(
            StudentRepository studentRepository,
            InstructorRepository instructorRepository
    ) {
        this.studentRepository = studentRepository;
        this.instructorRepository = instructorRepository;
    }

    public void create(
            String name,
            Integer age,
            String phone,
            String email,
            Long advisorId
    ) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setPhone(phone);
        student.setEmail(email);
        student.setAdvisor(instructorRepository.findById(advisorId).orElse(null));
        studentRepository.save(student);
    }

    public Student readStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> readStudentAll() {
        return studentRepository.findAll();
    }

    public void update(
            Long id,
            String name,
            Integer age,
            String phone,
            String email,
            Long advisorId
    ) {
        Student target
                = studentRepository.findById(id).orElse(new Student());
        target.setName(name);
        target.setAge(age);
        target.setPhone(phone);
        target.setEmail(email);
        target.setAdvisor(instructorRepository.findById(advisorId).orElse(null));
        studentRepository.save(target);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

}
