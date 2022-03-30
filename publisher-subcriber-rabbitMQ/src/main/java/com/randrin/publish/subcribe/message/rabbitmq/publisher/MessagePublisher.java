package com.randrin.publish.subcribe.message.rabbitmq.publisher;

import com.randrin.publish.subcribe.message.rabbitmq.configuration.MessagingConfiguration;
import com.randrin.publish.subcribe.message.rabbitmq.dto.CustomMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class MessagePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String publishMessage(@RequestBody CustomMessage message) {
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        rabbitTemplate.convertAndSend(MessagingConfiguration.ROUTE_KEY, MessagingConfiguration.MESSAGE_QUEUE, message);
        return "Message published successfully.";
    }
}
