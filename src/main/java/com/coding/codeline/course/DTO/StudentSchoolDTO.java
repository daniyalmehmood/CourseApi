package com.coding.codeline.course.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class StudentSchoolDTO {

    public Integer schoolId;
    public Integer studentId;
    public String schoolName;
    public String studentName;
}
