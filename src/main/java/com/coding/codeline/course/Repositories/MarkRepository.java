package com.coding.codeline.course.Repositories;

import com.coding.codeline.course.Models.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Integer> {
    @Query(value = "select m from Mark m where m.course.name = :courseName ")
    List<Mark> getMarksByCourseName(@Param("courseName") String courseName);

    @Query(value = "select avg(m.obtainedMarks) from Mark m where m.course.name = :courseName ")
    Integer getAverageOfMarksByCourseName(@Param("courseName") String courseName);

    @Query(value = "select sum(m.obtainedMarks) from Mark m where m.course.student.id  = :studentId ")
    Integer getSumOfMarksByStudentId(@Param("studentId") Integer studentId);


    @Query(value = "select avg(m.obtainedMarks) from Mark m where m.course.student.id  = :studentId ")
    Integer getAvgOfMarksByStudentId(@Param("studentId") Integer studentId);

}
