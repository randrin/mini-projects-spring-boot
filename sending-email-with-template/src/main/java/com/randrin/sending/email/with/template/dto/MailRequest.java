package com.randrin.sending.email.with.template.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailRequest {

    private String name;
    private String to;
    private String from;
    private String subject;
}
