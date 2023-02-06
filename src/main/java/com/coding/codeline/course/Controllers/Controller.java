package com.coding.codeline.course.Controllers;

import com.coding.codeline.course.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    StudentService studentService;

    @GetMapping
    public void addStudent(){
        studentService.addStudent();
        studentService.addStudent();
    }
}
