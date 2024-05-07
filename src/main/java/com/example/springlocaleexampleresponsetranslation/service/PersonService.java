package com.example.springlocaleexampleresponsetranslation.service;

import com.example.springlocaleexampleresponsetranslation.enums.ResponseCodes;
import com.example.springlocaleexampleresponsetranslation.model.ApiResponse;
import com.example.springlocaleexampleresponsetranslation.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService {
    private final ResponseStatusMessageService rsmService;
    public ApiResponse getByID(String lang, Integer id) {
        log.info("getByID method started");
        ApiResponse response = new ApiResponse();
        try {
            Person person = Person.builder().id(id).name("Test").surname("Test").status(1).build();
            response.setResponse(person);
            String message = rsmService.getResponseMessage(ResponseCodes.SUCCESSFUL.getValue(), lang);
            response.setCode(ResponseCodes.SUCCESSFUL);
            log.info("getByID done. Response code message is: {}", message);
        }catch (Exception ex){
            response.setCode(ResponseCodes.INTERNAL_SERVER_ERROR);
            log.error("Error getByID: {}", ex.getMessage());
        }
        return response;
    }



    public ApiResponse add(String lang, Person person){
        log.info("add method started");
        ApiResponse response = new ApiResponse();
        try {
            Person savedPerson = Person.builder().id(person.getId())
                    .name(person.getName()).surname(person.getSurname())
                    .status(person.getStatus()).build();
            if(person.getStatus() == null){
                String demoErrorMessage = rsmService.getResponseMessage(ResponseCodes.INTERNAL_SERVER_ERROR.getValue(), lang);
                throw new RuntimeException(demoErrorMessage);
            }
            response.setResponse(savedPerson);
            String message = rsmService.getResponseMessage(ResponseCodes.SUCCESSFUL.getValue(), lang);
            response.setCode(ResponseCodes.SUCCESSFUL);
            log.info("add done. Response code message is: {}", message);
        }catch (Exception ex){
            response.setCode(ResponseCodes.INTERNAL_SERVER_ERROR);
            log.error("Error add: {}", ex.getMessage());
        }
        return response;
    }
}
