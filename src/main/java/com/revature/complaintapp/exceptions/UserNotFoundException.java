package com.revature.complaintapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class UserNotFoundException extends Exception {
    public  UserNotFoundException() {
        super("User not found");
    }
}
