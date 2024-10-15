package org.colak.mono.fromcallable;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
class FromCallableTest {

    public static void main() {
        Mono<String> userById = getUserById();
        userById.subscribe(
                result -> log.info("Result: {}", result),
                error -> log.error("Error: {}", error.getMessage())
        );
    }

    private static Mono<String> getUserById() {
        return Mono.fromCallable(() -> {
            return "User: John Doe"; // Simulated user data
        });
    }
}
