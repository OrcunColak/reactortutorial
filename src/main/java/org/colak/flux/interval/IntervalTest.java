package org.colak.flux.interval;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
class IntervalTest {

    public static void main(String[] args) {
        // Example of Flux generating values every second
        Flux<Long> flux = Flux.interval(Duration.ofSeconds(1))
                .take(5);// Limit to the first 5 elements


        flux.subscribe(
                result -> log.info("Result: {}", result),
                error -> log.error("Error: {}", error.getMessage())
        );

        // Sleep to keep the application running to observe the interval Flux
        try {
            Thread.sleep(4000); // Sleep for some seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
