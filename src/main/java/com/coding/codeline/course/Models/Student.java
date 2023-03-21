package com.coding.codeline.course.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
public class Student extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "student_name")
    String name;

    String rollNumber;

    @ManyToOne
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    School school;


}
