package com.department.departmentweb.controller;

import com.department.departmentweb.entities.Club;
import com.department.departmentweb.entities.Student;
import com.department.departmentweb.service.ClubServiceImpl;
import com.department.departmentweb.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    private StudentServiceImpl studentService;
    private ClubServiceImpl clubService;

    @Autowired
     RegistrationController(StudentServiceImpl studentService, ClubServiceImpl clubService)
    {
        this.studentService = studentService;
        this.clubService = clubService;
    }

    @RequestMapping("/")
    public String showHome()
    {
        return "home";
    }

    @RequestMapping("/signup")
    public String showRegister()
    {
        return "register";
    }

    @RequestMapping("/registerStudent")
    public String register(@ModelAttribute("studentData") Student student, ModelMap modelMap)
    {
        studentService.register(student);
        System.out.println("Registration Successful");
        return "login";
    }

    @RequestMapping("/showLogin")
    public String login()
    {
        return "login";
    }

    @RequestMapping("/loginStudent")
    public String showLogin(@ModelAttribute("loginStudent") Student student, ModelMap modelMap)
    {
        studentService.login(student.getEmail(), student.getPassword());
        System.out.println("Login Successful");
        String message = "Login Successful";
        String email = student.getEmail();
        modelMap.addAttribute("message",message);
        modelMap.addAttribute("email", email);
        return "login";
    }
//www.localhost:3000/dashboard?studentmail=mail

}
