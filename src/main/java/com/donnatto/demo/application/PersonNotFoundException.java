package com.donnatto.demo.application;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PersonNotFoundException extends RuntimeException {
    private final Integer httpStatus = HttpStatus.NOT_FOUND.value();

    public PersonNotFoundException(Integer id) {
        super(String.format("A person with ID %s was not found.", id.toString()));
    }
}
