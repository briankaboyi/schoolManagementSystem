package com.school.demo.service;

import com.school.demo.entities.Student;
import com.school.demo.repositories.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
StudentService implements StudentServiceImpl {
    StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public String createStudent(Student student) {
        Optional<Student> studentOptional = studentRepo.findByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            return "Student already exists";
        }
        studentRepo.save(student);
        return "Student created successfully";
    }

    @Override
    public Optional<Student> findStudentById(Long id) {
        return studentRepo.findById(id);

    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        Student studentSaved = studentRepo.findByEmail(student.getEmail()).orElseThrow(() -> new RuntimeException("Student not found"));
        studentSaved.setEmail(studentSaved.getEmail());
        studentSaved.setName(student.getName() != null ? student.getName() : studentSaved.getName());
        studentSaved.setAge(student.getAge() != 0 ? student.getAge() : studentSaved.getAge());
        studentSaved.setPhoneNubmer(student.getPhoneNubmer() != null ? student.getPhoneNubmer() : studentSaved.getPhoneNubmer());
        studentRepo.save(studentSaved);

        return studentSaved;

//      if(studentSaved.isPresent()) {
//          studentSaved.get().setName(student.getName());
//          studentSaved.get().setAge(student.getAge());
//          studentSaved.get().setEmail(student.getEmail());
//          studentSaved.get().setPhoneNubmer(student.getPhoneNubmer());
//          studentRepo.save(studentSaved.get());
//          return studentSaved.get();
//      }
//      throw new RuntimeException("Student does not exist");
    }

    @Override
    @Transactional
    public String deleteStudent(Long id) {
         studentRepo.deleteById(id);
         return "Student successfully deleted";


    }

//    @Override
//    public String deleteStudent(Long id) {
//        Optional<Student> optionalStudent = findStudentById(id)
//    }


}
