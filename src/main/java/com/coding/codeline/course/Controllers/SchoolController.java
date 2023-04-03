package com.coding.codeline.course.Controllers;

import com.coding.codeline.course.Models.School;
import com.coding.codeline.course.RequestObjects.SchoolRequestForCreateDateUpdate;
import com.coding.codeline.course.Services.ReportService;
import com.coding.codeline.course.Services.SchoolService;
import com.coding.codeline.course.Slack.SlackClient;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {


    @Autowired
    SchoolService schoolService;

    @Autowired
    SlackClient slackClient;

    @Autowired
    ReportService reportService;

    //localhost:8080/school/getAll

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> schools = new ArrayList<>();
        schools = schoolService.getAllSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
        return schools;
    }


    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());

        return school;
    }

    @RequestMapping(value = "getByName")
    public School getSchoolByName(@RequestParam String schoolName) {
        School school = schoolService.getSchoolByName(schoolName);
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
        return school;
    }

    @RequestMapping(value = "getAllSchoolByIsActive")
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(activeSchoolsList).toString());
        return activeSchoolsList;
    }

    @RequestMapping(value = "updateCreatedDateByUserInput")
    public void setCreatedDateByUserInput(@RequestBody SchoolRequestForCreateDateUpdate data)
            throws ParseException {
        schoolService.setCreatedDateByUserInput(data.getDate(), data.getId());

    }

    @RequestMapping(value = "getSchoolByNumberOfStudent")
    public List<School> getSchoolByNumberOfStudent(@RequestParam Integer numberOfStudent) {
       List<School> schoolList=schoolService.getSchoolByNumberOfStudent(numberOfStudent);
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schoolList).toString());
       return schoolList;
    }

    @RequestMapping(value = "report")
    public String generateSchoolsReport() throws JRException, FileNotFoundException {
        return reportService.generateReport();
    }


}

