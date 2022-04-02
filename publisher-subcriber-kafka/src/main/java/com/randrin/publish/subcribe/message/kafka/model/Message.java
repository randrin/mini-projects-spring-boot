package com.randrin.publish.subcribe.message.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {

    private String name;
    private String email;
    private String subject;
    private String title;
    private Date dateCreated;
}
