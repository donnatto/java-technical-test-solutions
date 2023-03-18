package com.donnatto.demo.infrastructure;

import com.donnatto.demo.model.Person;
import com.donnatto.demo.model.Planet;

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

    static Planet toPlanet(PlanetResponse response) {
        return Planet.builder()
                .climate(response.getClimate())
                .diameter(response.getDiameter())
                .gravity(response.getGravity())
                .name(response.getName())
                .population(response.getPopulation())
                .residents(response.getResidents())
                .terrain(response.getTerrain())
                .url(response.getUrl())
                .build();
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

    static Person toPerson(PeopleResponse response) {
        return Person.builder()
                .name(response.getName())
                .birthYear(response.getBirthYear())
                .eyeColor(response.getEyeColor())
                .gender(response.getGender())
                .hairColor(response.getHairColor())
                .height(response.getHeight())
                .homeworld(response.getHomeworld())
                .mass(response.getMass())
                .skinColor(response.getSkinColor())
                .created(response.getCreated())
                .edited(response.getEdited())
                .url(response.getUrl())
                .build();
    }
}
