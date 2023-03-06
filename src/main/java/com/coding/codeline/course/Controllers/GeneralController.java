package com.coding.codeline.course.Controllers;

import com.coding.codeline.course.Services.SchoolService;
import com.coding.codeline.course.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("dev")

public class GeneralController {

    @GetMapping(value = "test")
    public String test(){
        return "${spring.profiles.active}";
    }
}
