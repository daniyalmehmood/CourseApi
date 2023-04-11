package com.coding.codeline.course.Repositories;

import com.coding.codeline.course.Models.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MarkRepository extends JpaRepository<Mark, Integer> {


}
