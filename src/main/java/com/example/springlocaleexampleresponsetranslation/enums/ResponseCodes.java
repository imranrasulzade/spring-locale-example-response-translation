package com.example.springlocaleexampleresponsetranslation.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ResponseCodes {
    SUCCESSFUL(2000),
    BAD_REQUEST(4000),
    UNKNOWN_ERROR(5001),
    INTERNAL_SERVER_ERROR(5005);

    private final int value;

    private static final Map<Integer, ResponseCodes> map = new HashMap<>();

    ResponseCodes(int value){
        this.value = value;
    }

    static {
        for(ResponseCodes responseCode : ResponseCodes.values()){
            map.put(responseCode.value, responseCode);
        }
    }

    @JsonCreator
    public static ResponseCodes valueOf(int code){
        return map.get(code);
    }

    @JsonValue
    public int getValue(){
        return value;
    }

}
