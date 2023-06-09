package com.donnatto.demo.model;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends ReactiveCrudRepository<Planet, Integer> {
}
