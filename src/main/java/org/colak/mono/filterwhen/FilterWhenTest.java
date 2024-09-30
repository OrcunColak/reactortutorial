package org.colak.mono.filterwhen;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
class FilterWhenTest {

    public static void main(String[] args) {
        Mono<String> filteredMono = Mono.just("hello")
                .filterWhen(value -> Mono.just(value.startsWith("h")));

        // Subscribe to the Mono and handle the result or error
        filteredMono.subscribe(
                result -> log.info("Result: {}", result),
                error -> log.error("Error: {}", error.getMessage())
        );
    }
}
