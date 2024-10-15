package org.colak.mono.error;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
class ErrorTest {

    public static void main() {
        // Create a Mono with a simulated error
        Mono<String> errorMono = Mono.error(new IndexOutOfBoundsException("Simulated error"));

        // Subscribe to the Mono and handle the result or error
        errorMono.subscribe(
                result -> log.info("Result: {}", result),
                error -> log.error("Error: {}", error.getMessage())
        );
    }
}
