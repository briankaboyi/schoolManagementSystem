package com.school.demo.repositories;

import com.school.demo.entities.StudentFile;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepo extends JpaRepository<StudentFile,Long> {

//   Optional<StudentFile> findByName(String name);
}
