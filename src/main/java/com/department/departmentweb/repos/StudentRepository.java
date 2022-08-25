package com.department.departmentweb.repos;

import com.department.departmentweb.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> getStudentsByEmail(String email);
}
