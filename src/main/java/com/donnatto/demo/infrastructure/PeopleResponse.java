package com.donnatto.demo.infrastructure;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PeopleResponse {

    private String name;
    @JsonProperty("birth_year")
    private String birthYear;
    @JsonProperty("eye_color")
    private String eyeColor;
    private String gender;
    @JsonProperty("hair_color")
    private String hairColor;
    private String height;
    private String homeworld;
    private String mass;
    @JsonProperty("skin_color")
    private String skinColor;
    private String created;
    private String edited;
    private String url;
}
