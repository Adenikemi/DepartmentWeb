package com.department.departmentweb.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String registrationNumber;
    private String age;
    private String birthDate;
    @Column(unique = true)
    private String email;
    private String password;
    private boolean hasPaidDues;

    public Student() {
    }

    public Student(Long id, String firstName, String middleName, String lastName, String registrationNumber, String age, String birthDate, String email, String password, boolean hasPaidDues) {
        id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.registrationNumber = registrationNumber;
        this.age = age;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.hasPaidDues = hasPaidDues;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isHasPaidDues() {
        return hasPaidDues;
    }

    public void setHasPaidDues(boolean hasPaidDues) {
        this.hasPaidDues = hasPaidDues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return hasPaidDues == student.hasPaidDues && Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(middleName, student.middleName) && Objects.equals(lastName, student.lastName) && Objects.equals(registrationNumber, student.registrationNumber) && Objects.equals(age, student.age) && Objects.equals(birthDate, student.birthDate) && Objects.equals(email, student.email) && Objects.equals(password, student.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middleName, lastName, registrationNumber, age, birthDate, email, password, hasPaidDues);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", age='" + age + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", hasPaidDues=" + hasPaidDues +
                '}';
    }
}
