package com.donnatto.demo.model;

import reactor.core.publisher.Flux;

import java.util.List;

public interface SwapiService {
    Flux<Planet> getPlanets(List<Integer> pages);
    Flux<Person> getPeople(List<Integer> pages);
}
