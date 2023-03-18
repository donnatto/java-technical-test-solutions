package com.donnatto.demo.infrastructure;

import com.donnatto.demo.model.Person;
import com.donnatto.demo.model.Planet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    private Mapper() {}

    static List<Planet> toPlanetList(GetPlanetsResponse response) {
        return response.getResults()
                .stream()
                .map(planet -> Planet.builder()
                        .climate(planet.getClimate())
                        .diameter(planet.getDiameter())
                        .gravity(planet.getGravity())
                        .name(planet.getName())
                        .population(planet.getPopulation())
                        .residents(planet.getResidents())
                        .terrain(planet.getTerrain())
                        .url(planet.getUrl())
                        .build())
                .collect(Collectors.toList());
    }

    static List<Person> toPersonList(GetPeopleResponse response) {
        return response.getResults()
                .stream().map(person -> Person.builder()
                        .name(person.getName())
                        .birthYear(person.getBirthYear())
                        .eyeColor(person.getEyeColor())
                        .gender(person.getGender())
                        .hairColor(person.getHairColor())
                        .height(person.getHeight())
                        .homeworld(person.getHomeworld())
                        .mass(person.getMass())
                        .skinColor(person.getSkinColor())
                        .created(person.getCreated())
                        .edited(person.getEdited())
                        .url(person.getUrl())
                        .build())
                .collect(Collectors.toList());
    }
}
