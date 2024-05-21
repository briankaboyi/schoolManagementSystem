package com.school.demo.service;

import com.school.demo.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentServiceImpl {
   public String createStudent(Student student);
   public Optional<Student> findStudentById(Long id);
   public List<Student> findAllStudents();
    public Student updateStudent(Student student);
    public String deleteStudent(Long id);

}
