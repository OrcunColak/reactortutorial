package org.colak.flux.timeout;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
class TimeoutTest {

    public static void main(String[] args) {
        Flux<Long> timedFlux = Flux.interval(Duration.ofSeconds(1))
                .take(10)
                .timeout(Duration.ofMillis(500));

        timedFlux.subscribe(
                result -> log.info("Result: {}", result),
                error -> log.error("Error: {}", error.getMessage())
        );
    }
}
