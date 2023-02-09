package com.coding.codeline.course.Services;

import com.coding.codeline.course.Models.School;
import com.coding.codeline.course.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    public List<School> getAllSchools(){

        return schoolRepository.getAllSchools();
    }
}
