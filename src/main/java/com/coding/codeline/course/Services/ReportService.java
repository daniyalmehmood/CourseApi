package com.coding.codeline.course.Services;

import com.coding.codeline.course.DTO.*;
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
    public String reportPrinting(JRBeanCollectionDataSource dataSource, String jasperReportName, String fileName) throws Exception {
        File file = new File("C:\\Users\\MuhammadDaniyal\\Downloads\\Daniyal\\CourseApi\\src\\main\\resources\\" + jasperReportName + ".jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Daniyal");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\" + fileName + ".pdf");
        return "Report generated : " + pathToReports + "\\" + fileName + ".pdf";
    }
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

    public String generateTopPerformingStudentReport() throws JRException {

        List<School> schoolList = schoolRepository.findAll();
        Map<School, Student> schoolStudentMap = new HashMap<>();
        List<TopPreformingStudentDTO> topPreformingStudentDTOSList = new ArrayList<>();

        for (School school : schoolList) {
            List<Student> studentList = studentRepository.getStudentsBySchoolId(school.getId());
            Integer highestMarks = 0;
            Student studentWithHighestMarks = new Student();
            for (Student student : studentList) {
                Integer studentId = student.getId();
                Integer studentTotalMark = markRepository.getSumOfMarksByStudentId(studentId);
                if (studentTotalMark > highestMarks) {
                    highestMarks = studentTotalMark;
                    studentWithHighestMarks = student;
                }
            }
            schoolStudentMap.put(school, studentWithHighestMarks);
            topPreformingStudentDTOSList.add(new TopPreformingStudentDTO(school.getName(), studentWithHighestMarks.getName()));
        }

        File file = new File("C:\\Users\\MuhammadDaniyal\\Downloads\\Daniyal\\CourseApi\\src\\main\\resources\\TopPreformingStudent.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(topPreformingStudentDTOSList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Daniyal");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\TopPreformingStudent.pdf");
        return "Report generated : " + pathToReports + "\\TopPreformingStudent.pdf";
    }

    public String overAllPerformanceForEachStudent() throws Exception {
        List<Student> studentList = studentRepository.findAll();
        List<StudentOverAllPerformanceDTO> studentOverAllPerformanceDTOS = new ArrayList<>();
        for (Student student : studentList) {
            Integer studentId = student.getId();
            String studentName = student.getName();
            String studentRollNumber = student.getRollNumber();
            Integer studentAverageMarks = markRepository.getAvgOfMarksByStudentId(studentId);
            StudentOverAllPerformanceDTO dto = new StudentOverAllPerformanceDTO(studentName, studentRollNumber, studentAverageMarks);
            studentOverAllPerformanceDTOS.add(dto);
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentOverAllPerformanceDTOS);

        return reportPrinting(dataSource,"OverallStudentPerformance","OverAllStudentPerformance");

    }
    public String totalCountOfStudents()throws Exception{
        List<School> schoolList = schoolRepository.getAllSchools();
        List<CountOfStudentWithSchoolDTO> countOfStudent = new ArrayList<>();
        for (School school:schoolList) {
            Integer schoolId = school.getId();
            String schoolName = school.getName();
            Integer countOfStudents = studentRepository.getCountOfStudentsBySchoolId(schoolId);
            CountOfStudentWithSchoolDTO countOfStudentWithSchoolDTO = new CountOfStudentWithSchoolDTO(countOfStudents,schoolName);
            countOfStudent.add(countOfStudentWithSchoolDTO);
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(countOfStudent);
        return reportPrinting(dataSource,"CountOfStudentsBySchool","CountOfStudentsBySchool");
    }


}

