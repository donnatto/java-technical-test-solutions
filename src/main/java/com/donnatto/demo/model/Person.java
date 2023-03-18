package com.donnatto.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
    private Integer id;
    private String name;
    private String birthYear;
    private String eyeColor;
    private String gender;
    private String hairColor;
    private String height;
    private String homeworld;
    private String mass;
    private String skinColor;
    private String created;
    private String edited;
    private String url;
}
