package com.example.springlocaleexampleresponsetranslation.model;

import com.example.springlocaleexampleresponsetranslation.enums.ResponseCodes;

public class ApiResponse {
    private ResponseCodes code;
    private Object response;

    public ApiResponse(){
        this.code = ResponseCodes.UNKNOWN_ERROR;
    }

    public ApiResponse(ResponseCodes code){
        this.code = code;
    }

    public ApiResponse(ResponseCodes code, Object response){
        this.code = code;
        this.response = response;
    }

    public ResponseCodes getCode(){
        return code;
    }
    public void setCode(ResponseCodes code){
        this.code = code;
    }

    public Object getResponse(){
        return response;
    }

    public void setResponse(Object response){
        this.response = response;
    }


}
