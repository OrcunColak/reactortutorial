package org.colak.flux.merge;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

// Flux.merge and Flux.concat are similar
@Slf4j
class MergeTest {

    public static void main() {
        Flux<Integer> mergedFlux = Flux.merge(Flux.just(1, 2, 3), Flux.just(4, 5, 6));

        mergedFlux.subscribe(
                result -> log.info("Result: {}", result),
                error -> log.error("Error: {}", error.getMessage())
        );
    }
}
