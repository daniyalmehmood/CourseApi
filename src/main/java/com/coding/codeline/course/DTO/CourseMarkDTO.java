package com.coding.codeline.course.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class CourseMarkDTO {

    String courseName;
    Integer obtainedMarks;
    String grade;
    Integer averageMark;

    public CourseMarkDTO(String courseName, Integer averageMark) {
        this.courseName = courseName;
        this.averageMark = averageMark;
    }
}
