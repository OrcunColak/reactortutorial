package org.colak.mono.onerrorresume;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


// onErrorResume provides a fallback value
@Slf4j
class OnErrorResumeTest {

    public static void main(String[] args) {
        // Simulating a Mono that may encounter an error
        Mono<String> errorMono = Mono.error(new RuntimeException("Simulated error"));

        // Using onErrorResume to handle the error and provide a fallback value
        Mono<String> resultMono = errorMono.onErrorResume(
                // Providing a fallback value
                throwable -> Mono.just("Fallback Value"));

        // Subscribing to the resultMono
        resultMono.subscribe(value -> log.info("Result: {}", value),
                throwable -> log.error("Error in subscription: {}", throwable.getMessage()));
    }
}
