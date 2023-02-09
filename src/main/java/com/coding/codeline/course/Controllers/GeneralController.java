package com.coding.codeline.course.Controllers;

import com.coding.codeline.course.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {

    @Autowired
    StudentService studentService;

    @RequestMapping()
    public void addStudent() {
        studentService.addStudent();
        studentService.addStudent();
    }

    @GetMapping(value = "deleteById")
    public String deleteStudentById(@RequestParam Integer id) {
        studentService.deleteStudentById(id);
        return "Record Deleted Successfully :)";
    }


    @GetMapping(value = "student")
    public String helloStudent() {
        return "Hello Student";
    }
}
