package com.department.departmentweb.controller;

import com.department.departmentweb.dto.RequestDto;
import com.department.departmentweb.entities.Club;
import com.department.departmentweb.entities.Student;
import com.department.departmentweb.service.ClubServiceImpl;
import com.department.departmentweb.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DashboardController {

    private StudentServiceImpl studentService;
    private ClubServiceImpl clubService;

    @Autowired
    DashboardController(StudentServiceImpl studentService, ClubServiceImpl clubService)
    {
        this.studentService = studentService;
        this.clubService = clubService;
    }

    @RequestMapping("/dashboard")
    public String showDashboard(
            @RequestParam(value = "studentMail") String studentMail,
            ModelMap modelMap
    ) throws IllegalAccessException {
        Student student = studentService.getStudentByEmail(studentMail);
        modelMap.addAttribute(student);
        modelMap.addAttribute("email", studentMail);
        return "dashboard";
    }

    @RequestMapping("/clubs")
    public String showClubs(
            @ModelAttribute("getClubs") Club club,
            ModelMap modelMap,
            @RequestParam(value = "studentMail") String studentMail)  {
        List<Club> clubs = clubService.getClubs();
        modelMap.addAttribute("clubs",clubs);
        modelMap.addAttribute("studentMail", studentMail);
        return "clubs";
    }


    @RequestMapping("/courseDues")
    public String showCourseDues()
    {
        return "courseDues";
    }


    @RequestMapping("/aboutUs")
    public String showAboutUs()
    {
        return "aboutUs";
    }

    @RequestMapping("/clubRegister")
    public String showClubRegisterPage(ModelMap modelMap,
                                       @RequestParam(value="studentMail")String mail,
                                       @RequestParam(value="clubId")Long id,Model model) throws IllegalAccessException{
        Student student = studentService.getStudentByEmail(mail);
        Club club = clubService.getClubById(id);
        model.addAttribute("requestData", new RequestDto());


        modelMap.addAttribute("student",student);
        modelMap.addAttribute("club", club);
        return "clubRegister";
    }

   @RequestMapping("/addStudentToClub")
    public String addStudentToClub(
            ModelMap modelMap,
            @ModelAttribute("requestData") RequestDto requestDto)
    {
        System.out.println("Successful");
        System.out.println(requestDto);
        String email = clubService.addStudentToClub(requestDto);
        String message  = email + " has been added to club";
        modelMap.addAttribute("message",message);
        return "clubRegister";
    }

}
