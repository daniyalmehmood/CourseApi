package com.coding.codeline.course.Controllers;

import com.coding.codeline.course.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {

    @Autowired
    SlackClient slackClient;

    @GetMapping(value = "test")
    public String test(){
        return "${spring.profiles.active}";
    }

    @GetMapping(value = "slackMessage")
    public void message(@RequestParam String text){
        slackClient.sendMessage(text);
    }
}
