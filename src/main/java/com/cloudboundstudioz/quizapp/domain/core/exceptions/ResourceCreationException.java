package com.cloudboundstudioz.quizapp.domain.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class handles exceptions whenever there's a conflict creating or adding
 * a resource in the system.
 */
@ResponseStatus(value = HttpStatus.CONFLICT) // Tells Spring to send status "CONFLICT" when there is a failure creating or adding a resource
public class ResourceCreationException extends RuntimeException {
    public ResourceCreationException(String message) {
        super(message);
    }
}
