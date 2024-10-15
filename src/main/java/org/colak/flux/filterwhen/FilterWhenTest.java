package org.colak.flux.filterwhen;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
class FilterWhenTest {

    public static void main() {
        Flux<String> filteredFlux = Flux.just("one", "two", "three")
                .filter(s -> s.length() > 3);

        filteredFlux.subscribe(
                result -> log.info("Result: {}", result),
                error -> log.error("Error: {}", error.getMessage())
        );
    }
}
