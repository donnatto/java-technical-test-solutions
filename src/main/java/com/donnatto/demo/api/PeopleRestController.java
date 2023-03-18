package com.donnatto.demo.api;

import com.donnatto.demo.application.PeopleService;
import com.donnatto.demo.model.Person;
import com.donnatto.demo.model.SwapiService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/people")
@AllArgsConstructor
public class PeopleRestController {

    private final PeopleService peopleService;
    private final SwapiService swapiService;

    @GetMapping()
    public Mono<ResponseEntity<ResponseBody<List<Person>>>> getPeople(@RequestParam(name = "page") Integer page) {
        List<Integer> pages = IntStream.rangeClosed(1, page)
                .boxed()
                .collect(Collectors.toList());

        return swapiService.getPeople(pages)
                .collectList()
                .map(ResponseEntityBuilder::constructResponseEntity);
    }

    @GetMapping("/{peopleId}")
    public Mono<ResponseEntity<ResponseBody<Person>>> getPeopleById(@PathVariable Integer peopleId) {
        return swapiService.getPeopleById(peopleId)
                .map(ResponseEntityBuilder::constructResponseEntity);
    }
}
