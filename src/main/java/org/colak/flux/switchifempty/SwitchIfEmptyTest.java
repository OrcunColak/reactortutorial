package org.colak.flux.switchifempty;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
class SwitchIfEmptyTest {

    public static void main() {
        Flux<String> defaultFlux = Flux.<String>empty()
                .switchIfEmpty(Flux.just("default"));

        defaultFlux.subscribe(
                result -> log.info("Result: {}", result),
                error -> log.error("Error: {}", error.getMessage())
        );
    }
}
