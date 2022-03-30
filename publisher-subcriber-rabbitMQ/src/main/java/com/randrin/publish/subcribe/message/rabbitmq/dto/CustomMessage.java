package com.randrin.publish.subcribe.message.rabbitmq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomMessage {

    private String messageId;
    private String message;
    private Date messageDate;
}
