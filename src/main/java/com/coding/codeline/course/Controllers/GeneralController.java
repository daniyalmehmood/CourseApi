package com.coding.codeline.course.Controllers;

import com.coding.codeline.course.Models.School;
import com.coding.codeline.course.Models.Student;
import com.coding.codeline.course.Services.SchoolService;
import com.coding.codeline.course.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GeneralController {

    @Autowired
    StudentService studentService;

    @Autowired
    SchoolService schoolService;

    //School Apis

    //Student Apis
    //Course Apis
    //Mark Apis
}
