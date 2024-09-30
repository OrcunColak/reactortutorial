package org.colak.flux.error;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
class ErrorTest {

    public static void main(String[] args) {
        // Create a Mono with a simulated error
        Flux<String> errorFlux = Flux.error(new IndexOutOfBoundsException("Simulated error"));

        // Subscribe to the Mono and handle the result or error
        errorFlux.subscribe(
                result -> log.info("Result: {}", result),
                error -> log.error("Error: {}", error.getMessage())
        );
    }
}
