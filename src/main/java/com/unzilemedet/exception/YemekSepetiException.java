package com.unzilemedet.exception;

import lombok.Getter;

@Getter
public class YemekSepetiException extends RuntimeException{
    private final ErrorType errorType;
    public YemekSepetiException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }

    public YemekSepetiException(ErrorType errorType, String message){
        super(message);
        this.errorType=errorType;
    }
}
