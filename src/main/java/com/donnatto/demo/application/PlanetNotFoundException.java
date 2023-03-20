package com.donnatto.demo.application;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PlanetNotFoundException extends RuntimeException {
    private final Integer httpStatus = HttpStatus.NOT_FOUND.value();

    public PlanetNotFoundException(Integer id) {
        super(String.format("A planet with ID %s was not found.", id.toString()));
    }
}
