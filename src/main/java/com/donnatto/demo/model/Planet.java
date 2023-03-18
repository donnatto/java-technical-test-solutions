package com.donnatto.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Planet {
    private Integer id;
    private String climate;
    private String diameter;
    private String gravity;
    private String name;
    private String population;
    private List<String> residents;
    private String terrain;
    private String url;
}
