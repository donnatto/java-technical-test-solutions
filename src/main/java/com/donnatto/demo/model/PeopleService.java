package com.donnatto.demo.model;

import reactor.core.publisher.Mono;

public interface PeopleService {
    Mono<Person> getPeopleById(Integer id);
}
