package org.colak.mono.switchifempty;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
class SwitchIfEmptyTest {
    public static void main() {
        // Create an empty Mono
        Mono.empty()
                // Use switchIfEmpty to emit a default value if the source Mono is empty
                .switchIfEmpty(Mono.just("Default Value"))
                // Subscribe to the Mono and print the emitted value
                .subscribe(value -> log.info("Emitted Value: " + value));

        // Create a Mono with a value
        Mono.just("Non-empty Value")
                // Use switchIfEmpty to emit a default value if the source Mono is empty
                .switchIfEmpty(Mono.just("Default Value"))
                // Subscribe to the Mono and print the emitted value
                .subscribe(value -> log.info("Emitted Value: " + value));
    }
}
