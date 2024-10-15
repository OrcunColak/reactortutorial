package org.colak.mono.subscribeon;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
class SubscribeOnBoundedElastic {

    public static void main() throws InterruptedException {
        Mono<String> userById = getUserById();
        userById.
                subscribeOn(Schedulers.boundedElastic())
                .subscribe(
                        // Runs on boundedElastic-1
                        result -> log.info("Result: {}", result),
                        error -> log.error("Error: {}", error.getMessage())
                );

        // Wait for a moment to ensure the asynchronous operation completes
        Thread.sleep(1000);  // Adjust the sleep time as needed

    }

    private static Mono<String> getUserById() {
        return Mono.fromCallable(() -> {
            // Runs on boundedElastic-1
            log.info("getUserById is called");
            return "User: John Doe"; // Simulated user data
        });
    }
}
