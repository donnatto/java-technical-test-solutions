package com.donnatto.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "people")
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
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
