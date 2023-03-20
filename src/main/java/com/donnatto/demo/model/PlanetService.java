package com.donnatto.demo.model;

import reactor.core.publisher.Mono;

public interface PlanetService {
    Mono<Planet> getPlanetById(Integer id);
}
