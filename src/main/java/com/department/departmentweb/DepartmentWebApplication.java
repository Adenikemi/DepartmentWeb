package com.department.departmentweb;

import com.department.departmentweb.entities.Club;
import com.department.departmentweb.entities.Student;
import com.department.departmentweb.repos.ClubRepository;
import com.department.departmentweb.repos.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DepartmentWebApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(DepartmentWebApplication.class, args);
    }
    /*@Bean
    public CommandLineRunner loadClubs(ClubRepository clubRepository, StudentRepository studentRepository){
        return args ->
        {
            Club club = new Club();
            Student student = new Student();
            List<Student> students = new ArrayList<>();
            students.add(student);
            student.setFirstName("Nike");
            student.setLastName("Awode");
            student.setAge("22");
            student.setEmail("omoseye@gmail.com");
            student.setMiddleName("weight");
            student.setBirthDate("12/12/1999");
            student.setPassword("registration");
            student.setHasPaidDues(false);
            student.setRegistrationNumber("12293739");
            studentRepository.save(student);
            club.setName("Data Science");
            club.setLecturerName("Mrs Afolabi");
            club.setRegisteredStudent(students);
            clubRepository.save(club);

            Club club1 = new Club();
            club1.setName("Web Development");
            club1.setLecturerName("Mrs Theresa");
            club.setRegisteredStudent(students);
            clubRepository.save(club1);

            Club club2= new Club();
            club2.setName("Full Stack Development");
            club2.setLecturerName("Dr Azu");
            club.setRegisteredStudent(students);
            clubRepository.save(club2);

            Club club3 = new Club();
            club3.setName("UI/UX");
            club3.setLecturerName("Mrs Ishewon");
            club.setRegisteredStudent(students);
            clubRepository.save(club3);

            Club club4 = new Club();
            club4.setName("Node Js");
            club4.setLecturerName("Dr Emebo");
            club.setRegisteredStudent(students);
            clubRepository.save(club4);

            Club club5 = new Club();
            club5.setName("Animation");
            club5.setLecturerName("Mr Jonathan");
            club.setRegisteredStudent(students);
            clubRepository.save(club5);
        };
    }*/

}
