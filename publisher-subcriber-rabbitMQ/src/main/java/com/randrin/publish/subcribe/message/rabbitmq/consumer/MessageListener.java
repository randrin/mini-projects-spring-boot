package com.randrin.publish.subcribe.message.rabbitmq.consumer;

import com.randrin.publish.subcribe.message.rabbitmq.configuration.MessagingConfiguration;
import com.randrin.publish.subcribe.message.rabbitmq.dto.CustomMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageListener {

    @RabbitListener(queues = MessagingConfiguration.MESSAGE_QUEUE)
    public void ListenerMessage(CustomMessage message) {
        System.out.println(message);
    }
}
