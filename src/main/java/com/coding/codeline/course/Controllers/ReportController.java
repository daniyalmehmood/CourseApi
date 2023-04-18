package com.coding.codeline.course.Controllers;

import com.coding.codeline.course.Services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "report")
public class ReportController {

    @Autowired
    ReportService reportService;

    @RequestMapping(method = RequestMethod.GET, value = "/getStudentSchoolNameReport")
    public String getReportForStudentSchoolName() {


        try {
            return reportService.generateReportForStudentWithSchoolName();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Exception("Error").getMessage();

        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "ReportForAverageMarks")
    public String generateReportForCourseMark() {
        try {
            return reportService.generateAverageMarkReport();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Exception("Error").getMessage();

        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "generateTopPerformingStudentReport")
    public String generateTopPerformingStudentReport() {
        try {
            return reportService.generateTopPerformingStudentReport();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Exception("Error").getMessage();

        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "generateOverAllPerformanceForEachStudent")
    public String generateOverAllPerformanceForEachStudent() {
        try {
            return reportService.overAllPerformanceForEachStudent();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Exception("Error").getMessage();

        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "CountOfStudentWithSchool")
    public String generateCountOfStudentWithSchool() {
        try {
            return reportService.totalCountOfStudents();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Exception("Error").getMessage();

        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "TheDistributionOfGrades")
    public String generateTheDistributionOfGrades() {
        try {
            return reportService.getTheDistributionOfGrades();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Exception("Error").getMessage();

        }
    }
}
