package com.department.departmentweb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ClubNotFoundException extends RuntimeException{
    public ClubNotFoundException(String message) {
        super(message);
    }
}
