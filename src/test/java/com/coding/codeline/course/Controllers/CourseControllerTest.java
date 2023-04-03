package com.coding.codeline.course.Controllers;

import com.coding.codeline.course.Models.Course;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseControllerTest {

    @Autowired
    CourseController courseController;

    @Test
    void getCourseById() throws Exception {
        Course courseToTest = courseController.getCourseById(1);
        String courseName = courseToTest.getName();
        assertEquals("MATHS" , courseName);
    }

    @Test
    void getCourseByIdWhenIdZero() throws Exception {
        Course courseToTest = courseController.getCourseById(0);
        assertEquals(null , courseToTest);
    }



    @Test
    void getCourseByIdThrowsErrorOnInvalidId() throws Exception {
        assertThrows(Exception.class, (Executable) courseController.getCourseById(0));
    }
}