package com.department.departmentweb.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lecturerName;

    @OneToMany
    private List<Student> registeredStudent;


    public Club() {
    }

    public Club(Long id,String name, Student registeredStudent, String lecturerName) {
        this.id = id;
        this.name = name;
        this.registeredStudent = (List<Student>) registeredStudent;
        this.lecturerName = lecturerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getRegisteredStudent() {
        return registeredStudent;
    }

    public void setRegisteredStudent(List<Student> registeredStudent) {
        this.registeredStudent = registeredStudent;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return Objects.equals(id, club.id) && Objects.equals(name, club.name) && Objects.equals(lecturerName, club.lecturerName) && Objects.equals(registeredStudent, club.registeredStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lecturerName, registeredStudent);
    }

    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lecturerName='" + lecturerName + '\'' +
                ", registeredStudent=" + registeredStudent +
                '}';
    }
}
