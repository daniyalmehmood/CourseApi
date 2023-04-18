package com.coding.codeline.course.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public class CountOfStudentWithSchoolDTO {
    Integer countOfStudents;
    String schoolName;

}
