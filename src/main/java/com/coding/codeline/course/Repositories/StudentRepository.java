package com.coding.codeline.course.Repositories;

import com.coding.codeline.course.Models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
