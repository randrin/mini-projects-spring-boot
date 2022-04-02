package com.randrin.publish.subcribe.message.kafka.publisher;

import com.randrin.publish.subcribe.message.kafka.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class PublisherController {

    @Autowired
    KafkaTemplate<String, Message> kafkaTemplate;

    public static final String TOPIC_NAME = "topic-name";

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Message message) {
        message.setDateCreated(new Date());
        kafkaTemplate.send(TOPIC_NAME, message);
        return "Message published successfully.";
    }
}
