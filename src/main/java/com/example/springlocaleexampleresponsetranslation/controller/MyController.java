package com.example.springlocaleexampleresponsetranslation.controller;

import com.example.springlocaleexampleresponsetranslation.model.ApiResponse;
import com.example.springlocaleexampleresponsetranslation.model.Person;
import com.example.springlocaleexampleresponsetranslation.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public ApiResponse getByID(@RequestHeader(name = "lang", required = false, defaultValue = "az") String lang,
                               @PathVariable Integer id) {
        return personService.getByID(lang, id);
    }

    @PostMapping
    public ApiResponse add(@RequestHeader(name = "lang", required = false, defaultValue = "az") String lang,
                           @RequestBody Person person) {
        return personService.add(lang, person);
    }
}
