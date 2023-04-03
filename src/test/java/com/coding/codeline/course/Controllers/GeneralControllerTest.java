package com.coding.codeline.course.Controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GeneralControllerTest {

    @Autowired
    GeneralController generalController;

    @Test
    void test1() {
        String profile = generalController.test();
        assertEquals("${spring.profiles.active}"  , profile);
    }

    @Test
    void test1WhereItIsNotEqual() {
        String profile = generalController.test();
        assertEquals("${spring.profiles.dev}"  , profile);
    }
    @Test
    void test1WhereItIsNull() {
        String profile = generalController.test();
        assertNotNull(profile);
    }

    @Test
    void message() {
    }
}