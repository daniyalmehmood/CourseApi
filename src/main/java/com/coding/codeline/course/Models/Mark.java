package com.coding.codeline.course.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data


@Entity
public class Mark extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer obtainedMarks;

    String grade;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    Course course;
}
