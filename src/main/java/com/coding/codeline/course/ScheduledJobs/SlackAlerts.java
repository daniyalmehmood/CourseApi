package com.coding.codeline.course.ScheduledJobs;

import com.coding.codeline.course.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SlackAlerts {

    @Autowired
    SlackClient slackClient;

    @Scheduled(cron = "*/5 * * * * *")
    public void alertSlack(){
        slackClient.sendMessage("<!here> *Technical Session @ 1, Lunch will be there* + time:" + new Date());
    }
}
