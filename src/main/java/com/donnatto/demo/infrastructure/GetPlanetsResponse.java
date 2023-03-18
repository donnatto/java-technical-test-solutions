package com.donnatto.demo.infrastructure;

import lombok.Getter;

import java.util.List;

@Getter
public class GetPlanetsResponse {
    private List<PlanetResponse> results;
}
