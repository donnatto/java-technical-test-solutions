package com.donnatto.demo.application;

import com.donnatto.demo.model.PeopleRepository;
import com.donnatto.demo.model.PeopleService;
import com.donnatto.demo.model.Person;
import com.donnatto.demo.model.SwapiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PeopleServiceImpl implements PeopleService {

    private final PeopleRepository peopleRepository;
    private final SwapiService swapiService;

    public Mono<Person> getPeopleById(Integer id) {
        return peopleRepository.findById(id)
                .switchIfEmpty(Mono.defer(() -> this.getPersonAndSaveIt(id)));
    }

    private Mono<Person> getPersonAndSaveIt(Integer id) {
        return swapiService.getPeopleById(id)
                .switchIfEmpty(Mono.error(new PersonNotFoundException(id)))
                .flatMap(person -> peopleRepository.save(person.toBuilder()
                        .id(id)
                        .newPerson(true)
                        .build()));
    }
}
