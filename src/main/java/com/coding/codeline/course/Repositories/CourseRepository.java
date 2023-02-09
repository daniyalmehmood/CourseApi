package com.coding.codeline.course.Repositories;

import com.coding.codeline.course.Models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
