package com.example.springlocaleexampleresponsetranslation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("greeting")
public class GreetingController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/greet")
    public String greet(@RequestParam(value = "lang", defaultValue = "tr_TR") String lang) {
        Locale locale = new Locale(lang);
        return messageSource.getMessage("greeting", null, locale);
    }
}