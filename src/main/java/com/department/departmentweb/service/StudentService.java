package com.department.departmentweb.service;

import com.department.departmentweb.entities.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentService {

    void register(Student student);

    boolean login(String email, String password);

    Student getStudent(Long id);

    List<Student> getStudents();

    Student getStudentByEmail(String email) throws IllegalAccessException;

}
