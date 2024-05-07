package com.example.springlocaleexampleresponsetranslation.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseStatusMessageService {

    private Map<String, Map<String, String>> messages = new HashMap<>();

    public ResponseStatusMessageService() throws IOException {
        File file = new File("src/main/resources/response-message-translate.json");
        FileInputStream fis = new FileInputStream(file);
        String json = new String(fis.readAllBytes(), StandardCharsets.UTF_8);
        this.messages = new Gson().fromJson(json, new TypeToken<Map<String, Map<String, String>>>() {}.getType());
    }

    public String getResponseMessage(Integer respCode, String locale) {
        String code = String.valueOf(respCode);
        if (messages.containsKey(code)) {
            Map<String, String> message = messages.get(code);
            return message.getOrDefault(locale.toLowerCase(), "Locale not supported");
        } else {
            return "Response message not found";
        }
    }
}