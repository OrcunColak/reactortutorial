package org.colak.flux.error;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
class ErrorTest {

    public static void main(String[] args) {
        Flux<String> errorFlux = Flux.error(new IndexOutOfBoundsException("Simulated error"));

        errorFlux.subscribe(
                result -> log.info("Result: {}", result),
                error -> log.error("Error: {}", error.getMessage())
        );
    }
}
