package com.coding.codeline.course.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
public class Course extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    Student student;
}
