package com.coding.codeline.course.Services;

import com.coding.codeline.course.Repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkService {
    @Autowired
    MarkRepository markRepository;

    public Integer averageMark(String courseName) {
        Integer averageMark = markRepository.getAverageOfMarksByCourseName(courseName);
        return averageMark;
    }
}
