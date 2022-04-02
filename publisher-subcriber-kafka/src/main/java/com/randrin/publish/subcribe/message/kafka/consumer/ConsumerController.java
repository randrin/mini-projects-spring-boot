package com.randrin.publish.subcribe.message.kafka.consumer;

import com.randrin.publish.subcribe.message.kafka.configuration.ConsumerConfiguration;
import com.randrin.publish.subcribe.message.kafka.publisher.PublisherController;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class ConsumerController {

    @KafkaListener(topics = PublisherController.TOPIC_NAME, groupId = ConsumerConfiguration.GROUP_ID_CONFIG)
    public void consumeMessage(String message) {
        System.out.println(message);
    }
}
