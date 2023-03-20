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
@Table(name = "planets")
@AllArgsConstructor
@NoArgsConstructor
public class Planet implements Persistable<Integer> {
    @Id
    private Integer id;
    private String climate;
    private String diameter;
    private String gravity;
    private String name;
    private String population;
    private String terrain;
    private String url;

    @Transient
    @JsonIgnore
    private boolean newPlanet;

    @Override
    @Transient
    @JsonIgnore
    public boolean isNew() {
        return this.newPlanet || id == null;
    }
}
