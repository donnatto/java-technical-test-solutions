package com.donnatto.demo.application;

import com.donnatto.demo.model.Planet;
import com.donnatto.demo.model.PlanetRepository;
import com.donnatto.demo.model.PlanetService;
import com.donnatto.demo.model.SwapiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PlanetServiceImpl implements PlanetService {

    private final PlanetRepository planetRepository;
    private final SwapiService swapiService;

    public Mono<Planet> getPlanetById(Integer id) {
        return planetRepository.findById(id)
                .switchIfEmpty(Mono.defer(() -> this.getPlanetAndSaveIt(id)));
    }

    private Mono<Planet> getPlanetAndSaveIt(Integer id) {
        return swapiService.getPlanetById(id)
                .switchIfEmpty(Mono.error(new PlanetNotFoundException(id)))
                .flatMap(planet -> planetRepository.save(planet.toBuilder()
                        .id(id)
                        .newPlanet(true)
                        .build()));

    }
}
