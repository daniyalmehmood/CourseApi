package com.coding.codeline.course.Slack;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SlackClient {


    public String sendMessage(String text) {
        return "Done";
/*        return WebClient.create().post()
                .uri("https://hooks.slack.com/services/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")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new SlackPayload(text))
                .retrieve()
                .bodyToMono(String.class)
                .block();*/
    }


}
