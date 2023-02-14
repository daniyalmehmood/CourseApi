package com.coding.codeline.course.Controllers;

import com.coding.codeline.course.Models.Student;
import com.coding.codeline.course.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "student/getStudentsBySchoolName", method = RequestMethod.GET)
    public List<Student> getStudentsBySchoolName(@RequestParam String schoolName) {
        return studentService.getStudentsBySchoolName(schoolName);
    }
}
