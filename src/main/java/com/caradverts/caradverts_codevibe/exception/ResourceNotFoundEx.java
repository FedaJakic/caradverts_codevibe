package com.caradverts.caradverts_codevibe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundEx extends RuntimeException {
    public ResourceNotFoundEx() {
        super(String.format("No car advert with given id was found."));
    }

}
