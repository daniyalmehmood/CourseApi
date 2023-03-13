package com.coding.codeline.course.Slack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SlackClient {


    public String sendMessage(String text) {
        return WebClient.create().post()
                .uri("https://hooks.slack.com/services/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")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new SlackPayload(text))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


}
