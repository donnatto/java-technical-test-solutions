package com.donnatto.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "planets")
@AllArgsConstructor
@NoArgsConstructor
public class Planet {
    @Id
    private Integer id;
    private String climate;
    private String diameter;
    private String gravity;
    private String name;
    private String population;
    @ElementCollection
    private List<String> residents;
    private String terrain;
    private String url;
}
