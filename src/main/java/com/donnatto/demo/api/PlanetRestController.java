package com.donnatto.demo.api;

import com.donnatto.demo.model.Planet;
import com.donnatto.demo.model.SwapiService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/planets")
@AllArgsConstructor
public class PlanetRestController {

    private final SwapiService swapiService;

    @GetMapping()
    public Mono<ResponseEntity<ResponseBody<List<Planet>>>> getPlanets(@RequestParam(name = "page") Integer page) {
        List<Integer> pages = IntStream.rangeClosed(1, page)
                .boxed()
                .collect(Collectors.toList());

        return swapiService.getPlanets(pages)
                .collectList()
                .map(ResponseEntityBuilder::constructResponseEntity);
    }
}
