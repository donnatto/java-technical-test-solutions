package com.donnatto.demo.infrastructure;

import com.donnatto.demo.model.Person;
import com.donnatto.demo.model.Planet;
import com.donnatto.demo.model.SwapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class SwapiServiceImpl implements SwapiService {

    private final WebClient webClient;

    @Autowired
    public SwapiServiceImpl(@Value("${swapi.url}")String baseURL) {
        this.webClient = WebClient.builder()
                .baseUrl(baseURL)
                .build();
    }

    @Override
    public Flux<Planet> getPlanets(List<Integer> pages) {
        return Flux.fromIterable(pages)
                .flatMap(this::getPlanetsByPage);
    }

    private Flux<Planet> getPlanetsByPage(Integer page) {
        return webClient.get()
                .uri("/planets?page={page}", page)
                .retrieve()
                .bodyToMono(GetPlanetsResponse.class)
                .map(Mapper::toPlanetList)
                .flatMapMany(Flux::fromIterable);
    }

    @Override
    public Flux<Person> getPeople(List<Integer> pages) {
        return Flux.fromIterable(pages)
                .flatMap(this::getPeopleByPage);
    }

    private Flux<Person> getPeopleByPage(Integer page) {
        return webClient.get()
                .uri("/people?page={page}", page)
                .retrieve()
                .bodyToMono(GetPeopleResponse.class)
                .map(Mapper::toPersonList)
                .flatMapMany(Flux::fromIterable);
    }
}
