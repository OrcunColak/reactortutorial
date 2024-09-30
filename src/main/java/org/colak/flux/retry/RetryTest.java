package org.colak.flux.retry;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
class RetryTest {

    public static void main(String[] args) {
        Flux<Integer> retryFlux = Flux.range(1, 5)
                .map(i -> {
                    if (i == 3) {
                        throw new RuntimeException("Error at " + i);
                    }
                    return i;
                })
                .retry(2);

        retryFlux.subscribe(
                result -> log.info("Result: {}", result),
                error -> log.error("Error: {}", error.getMessage())
        );
    }
}
