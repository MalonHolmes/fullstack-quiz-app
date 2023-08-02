package com.cloudboundstudioz.quizapp.domain.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class handles the scenario when a resource isn't found in the system database.
 * So instead of a generic error, it returns a custom exception, message,
 * so the user can be more informed as to what's happening.
 * Inherits from RuntimeException because we want it to handle at Runtime.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND) // Tells Spring to send a response status "NOT FOUND" when resource isnt found
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
