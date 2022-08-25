package com.department.departmentweb.service;

import com.department.departmentweb.dto.RequestDto;
import com.department.departmentweb.entities.Club;
import com.department.departmentweb.entities.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClubService{
    String addStudentToClub(RequestDto requestDto);
    List<Club> getClubs();
    Club getClubById(Long id) throws IllegalAccessException;
}
