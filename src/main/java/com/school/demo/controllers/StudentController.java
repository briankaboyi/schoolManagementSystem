package com.school.demo.controllers;

import com.school.demo.entities.Student;
import com.school.demo.service.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/createStudent")
    public String createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @GetMapping("/{id}")
    public Optional<Student> findStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("/")
    public List<Student> findAllStudent() {
        return studentService.findAllStudents();
    }
    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam Long id){
        return studentService.deleteStudent(id);
    }


}
