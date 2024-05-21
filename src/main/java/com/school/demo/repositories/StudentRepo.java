package com.school.demo.repositories;

import com.school.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student ,Integer> {
    Optional<Student> findByEmail(String email);
    Optional<Student> findById(Long id);

    public void deleteById(Long id);
}
