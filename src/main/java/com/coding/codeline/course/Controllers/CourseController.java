package com.coding.codeline.course.Controllers;

import com.coding.codeline.course.Models.Course;
import com.coding.codeline.course.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "getById")
    public Course getCourseById(@RequestParam Integer courseId) {

        return courseService.getCourseById(courseId);

    }
}
