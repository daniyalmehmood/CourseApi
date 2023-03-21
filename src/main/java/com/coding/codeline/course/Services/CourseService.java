package com.coding.codeline.course.Services;

import com.coding.codeline.course.Models.Course;
import com.coding.codeline.course.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course getCourseById(Integer id){
        Course course = courseRepository.getCourseById(id);
        return course;
    }
}
