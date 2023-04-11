package com.coding.codeline.course.DTO;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithSchoolNameDTO {

    String schoolName;
    String studentName;
    String rollNumber;
}
