package com.coding.codeline.course.Controllers;

import com.coding.codeline.course.Models.School;
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

    @RequestMapping(value = "school/getAll", method = RequestMethod.GET)
    public List<School> getAllSchools(){
        List<School> schools = new ArrayList<>();
        schools = schoolService.getAllSchools();
        return schools;
    }





    //Student Apis
    //Course Apis
    //Mark Apis
}
