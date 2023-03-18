package com.donnatto.demo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {
    private ResponseEntityBuilder() {}

    public static <T> ResponseEntity<ResponseBody<T>> constructResponseEntity(T payload) {
        ResponseBody<T> responseBody = ResponseBody.<T>builder()
                .payload(payload)
                .status(HttpStatus.OK.value())
                .build();
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
