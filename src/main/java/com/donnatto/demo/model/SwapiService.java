package com.donnatto.demo.model;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface SwapiService {
    Flux<Planet> getPlanets(List<Integer> pages);
    Flux<Person> getPeople(List<Integer> pages);
    Mono<Planet> getPlanetById(Integer id);
    Mono<Person> getPeopleById(Integer id);
}
