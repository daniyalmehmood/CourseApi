package com.coding.codeline.course.Services;

import com.coding.codeline.course.Models.School;
import com.coding.codeline.course.Models.Student;
import com.coding.codeline.course.Repositories.SchoolRepository;
import com.coding.codeline.course.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SchoolRepository schoolRepository;

    public void addStudent() {
        Student student = new Student();
        student.setName("Muzzamil Arif");
        student.setRollNumber("1");
        studentRepository.save(student);

    }

    public void deleteStudentById(Integer id){
        Student studentToDelete = studentRepository.findById(id).get();
        studentRepository.delete(studentToDelete);
    }

    public List<Student> getStudentsBySchoolName(String schoolName){
        School school = schoolRepository.getBySchoolName(schoolName);
        Integer schoolId = school.getId();
        List<Student> studentList = studentRepository.getStudentsBySchoolId(schoolId);
        return studentList;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
