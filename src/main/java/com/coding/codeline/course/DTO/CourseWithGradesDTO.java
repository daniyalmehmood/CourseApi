package com.coding.codeline.course.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
@Setter
@AllArgsConstructor
public class CourseWithGradesDTO {
    String courseName;
    Integer countOfMarks;
    String grade;
}
