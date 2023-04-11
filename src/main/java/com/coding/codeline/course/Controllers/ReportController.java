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
    public String getReportForStudentSchoolName(){


        try {
            return reportService.generateReportForStudentWithSchoolName();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Exception("Error").getMessage();

        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/generateReportForCourseMark")
    public String generateReportForCourseMark(){


        try {
            return reportService.generateReportForCourseMark();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Exception("Error").getMessage();

        }
    }
}
