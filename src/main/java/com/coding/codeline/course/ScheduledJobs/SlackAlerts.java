package com.coding.codeline.course.ScheduledJobs;

import com.coding.codeline.course.Models.School;
import com.coding.codeline.course.Services.SchoolService;
import com.coding.codeline.course.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class SlackAlerts {

    @Autowired
    SlackClient slackClient;

    @Autowired
    SchoolService schoolService;

    @Scheduled(cron = "*/5 * * * * *")
    public void alertSlack() {
        slackClient.sendMessage("<!here> *Technical Session @ 1, Lunch will be there* + time:" + new Date());
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void getSchoolByNameAlert() {
        List<School> schoolList = schoolService.getAllSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schoolList).toString());
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void getSchoolByIdAlert(){
        School school = schoolService.getSchoolById(1);
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
    }
}
