package com.randrin.sending.email.with.template.controller;

import com.randrin.sending.email.with.template.dto.MailRequest;
import com.randrin.sending.email.with.template.dto.MailResponse;
import com.randrin.sending.email.with.template.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/sendmail")
    public MailResponse sendMail(@RequestBody MailRequest request) {
        Map<String, Object> model = new HashMap<>();
        model.put("name", request.getName());
        model.put("location", "France, Toulouse");
        return mailService.sendEmail(request, model);
    }
}
