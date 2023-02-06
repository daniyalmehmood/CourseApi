package com.coding.codeline.course.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "dbo.Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "student_name")
    String name;

    @Column(name = "student_rollNumber")
    String rollNumber;


}
