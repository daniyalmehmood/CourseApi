package com.coding.codeline.course.Services;

import com.coding.codeline.course.DTO.CourseMarkDTO;
import com.coding.codeline.course.DTO.StudentSchoolDTO;
import com.coding.codeline.course.DTO.StudentWithSchoolNameDTO;
import com.coding.codeline.course.Models.*;
import com.coding.codeline.course.Models.School;
import com.coding.codeline.course.Models.Student;
import com.coding.codeline.course.Repositories.CourseRepository;
import com.coding.codeline.course.Repositories.MarkRepository;
import com.coding.codeline.course.Repositories.SchoolRepository;
import com.coding.codeline.course.Repositories.StudentRepository;
import com.coding.codeline.course.RequestObjects.SchoolRequest;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    public static final String pathToReports = "C:\\Users\\MuhammadDaniyal\\Downloads\\Reports";

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    MarkRepository markRepository;

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;

    public String generateReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.getAllSchools();

        File file = ResourceUtils.getFile("classpath:School_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\schools.pdf");
        return "Report generated : " + pathToReports + "\\schools.pdf";
    }

    public String generateReportForStudentSchoolDto() throws FileNotFoundException, JRException {
        List<Student> studentsList = studentRepository.findAll();
        List<StudentSchoolDTO> studentSchoolDTO = new ArrayList<>();

        for (Student studentObject : studentsList) {
            StudentSchoolDTO dto = new StudentSchoolDTO();
            dto.setStudentId(studentObject.getId());
            dto.setSchoolId(studentObject.getSchool().getId());
            dto.setSchoolName(studentObject.getSchool().getName());
            dto.setStudentName(studentObject.getName());

            studentSchoolDTO.add(dto);
        }

        File file = ResourceUtils.getFile("classpath:Student_School.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentSchoolDTO);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\schools.pdf");
        return "Report generated : " + pathToReports + "\\schools.pdf";
    }

    public String generateReportForStudentWithSchoolName() throws Exception {

        List<Student> students = studentRepository.findAll();
        List<StudentWithSchoolNameDTO> studentSchoolNameDtosList = new ArrayList<>();
        for (Student student : students) {

            StudentWithSchoolNameDTO dto = new StudentWithSchoolNameDTO(student.getSchool().getName(),
                    student.getName(),
                    student.getRollNumber());

            studentSchoolNameDtosList.add(dto);
        }

        File file = new File("C:\\Users\\MuhammadDaniyal\\Downloads\\Daniyal\\CourseApi\\src\\main\\resources\\StudentWithSchoolName.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentSchoolNameDtosList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Daniyal");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\studentSchoolReport.pdf");
        return "Report generated : " + pathToReports + "\\studentSchoolReport.pdf";

    }

    public String generateAverageMarkReport() throws JRException {

        List<Course> courseList = courseRepository.findAll();
        List<CourseMarkDTO> courseMarkDTOList = new ArrayList<>();
        for (Course course : courseList) {
            String courseName = course.getName();
            Integer averageMark = markRepository.getAverageOfMarksByCourseName(courseName);
            courseMarkDTOList.add(new CourseMarkDTO(courseName, averageMark));
        }
        File file = new File("C:\\Users\\MuhammadDaniyal\\Downloads\\Daniyal\\CourseApi\\src\\main\\resources\\AverageMark.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseMarkDTOList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Daniyal");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\courseAverageMark.pdf");
        return "Report generated : " + pathToReports + "\\courseAverageMark.pdf";
    }
}
