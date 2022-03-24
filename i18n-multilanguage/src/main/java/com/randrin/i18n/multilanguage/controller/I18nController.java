package com.randrin.i18n.multilanguage.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/v1")
public class I18nController {

    private final MessageSource messageSource;

    public I18nController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping
    public String sayHello() {
        return messageSource.getMessage("common.hello", null, LocaleContextHolder.getLocale());
    }

    @GetMapping("/language")
    public String sayHelloWithHeader(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("common.hello", null, LocaleContextHolder.getLocale());
    }
}
