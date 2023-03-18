package com.donnatto.demo.api;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public final class ResponseBody<T> {
    private final T payload;
    private final int status;
}
