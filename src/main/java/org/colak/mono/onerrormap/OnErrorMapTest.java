package org.colak.mono.onerrormap;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

// onErrorMap transforms exceptions into other exceptions
@Slf4j
class OnErrorMapTest {

    public static void main() {
        // Create a Mono with a simulated error
        Mono<String> errorMono = Mono.error(new IndexOutOfBoundsException("Simulated error"));

        // Use onErrorMap to handle the error and map it to a new error
        Mono<String> handledMono = errorMono
                .onErrorMap(originalError ->
                        new RuntimeException("Error handled and mapped", originalError)
                );

        // Subscribe to the Mono and handle the result or error
        handledMono.subscribe(
                result -> log.info("Result: {}", result),
                error -> log.error("Error: {}", error.getMessage())
        );
    }
}
