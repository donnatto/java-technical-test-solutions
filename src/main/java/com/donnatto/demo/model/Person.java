package com.donnatto.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Builder(toBuilder = true)
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "people")
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Persistable<Integer> {
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

    @Transient
    @JsonIgnore
    private boolean newPerson;

    @Override
    @Transient
    @JsonIgnore
    public boolean isNew() {
        return this.newPerson || id == null;
    }
}
