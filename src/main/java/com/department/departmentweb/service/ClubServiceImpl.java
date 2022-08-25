package com.department.departmentweb.service;

import com.department.departmentweb.dto.RequestDto;
import com.department.departmentweb.entities.Club;
import com.department.departmentweb.entities.Student;
import com.department.departmentweb.exception.ClubNotFoundException;
import com.department.departmentweb.exception.StudentNotFoundException;
import com.department.departmentweb.repos.ClubRepository;
import com.department.departmentweb.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImpl implements ClubService{

    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private StudentRepository studentRepository;



    @Override
    public String addStudentToClub(RequestDto requestDto) {
       Optional<Club> club1  = clubRepository.findById((long) requestDto.getId());
       Optional<Student> student = studentRepository.getStudentsByEmail(requestDto.getEmail());
       if(club1.isEmpty())
       {
           throw new ClubNotFoundException("Club does not exist");
       }
       if(student.isEmpty())
       {
           throw new StudentNotFoundException("Student not found");
       }
        Club club = club1.get();
        Student student1 = student.get();
        club.getRegisteredStudent().add(student1);

        clubRepository.save(club);
        return student1.getEmail();
    }

    @Override
    public List<Club> getClubs() {
        return clubRepository.findAll();
    }

    @Override
    public Club getClubById(Long id) throws IllegalAccessException {
        Optional<Club> club = clubRepository.findById(id);

        if (club.isPresent()){
            return club.get();
        }
        else {
            throw new IllegalAccessException("User does not exist");
        }
    }
}
