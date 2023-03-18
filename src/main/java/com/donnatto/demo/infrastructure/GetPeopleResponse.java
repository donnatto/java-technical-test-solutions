package com.donnatto.demo.infrastructure;

import lombok.Getter;

import java.util.List;

@Getter
public class GetPeopleResponse {
    private List<PeopleResponse> results;
}
