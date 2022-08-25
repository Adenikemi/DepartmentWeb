package com.department.departmentweb.service;

import com.department.departmentweb.entities.Student;
import com.department.departmentweb.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    public StudentRepository studentRepository;

    @Override
    public void register(Student student) {
        studentRepository.save(student);
    }

    @Override
    public boolean login(String email, String password) {
        Optional<Student> student=studentRepository.getStudentsByEmail(email);
        if(student.isPresent()){
            if(student.get().getPassword() == password){
                return true;
            }
        }
        return  false;
    }

    @Override
    public Student getStudent(Long id) {
        Optional<Student> student =  studentRepository.findById(id);
        return student.get();
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByEmail(String email) throws IllegalAccessException {
        Optional<Student> student = studentRepository.getStudentsByEmail(email);

        if(student.isPresent()){
            return student.get();
        }else{
            throw new IllegalAccessException("Student does not exists");
        }
    }

}
