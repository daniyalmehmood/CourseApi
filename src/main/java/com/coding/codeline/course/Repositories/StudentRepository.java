package com.coding.codeline.course.Repositories;

import com.coding.codeline.course.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT st from Student st " +
            "WHERE st.school.id = :id ")
    List<Student> getStudentsBySchoolId(@Param("id") Integer id);

    @Query(value = "SELECT DISTINCT school_id FROM student", nativeQuery = true)
    List<Integer> getDistinctSchoolIdsFromStudent();

    @Query(value = "SELECT COUNT(id) From student where school_id = :?1", nativeQuery = true)
    Integer getCountOfStudentsBySchoolId(Integer schoolId);
}
