package org.colak.mono.zip;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

// The zip method combines multiple Mono instances into a single Mono, emitting a Tuple containing the values emitted by the individual Monos
@Slf4j
class ZipTest {
    public static void main(String[] args) {
        // Create two Monos emitting strings
        Mono<String> mono1 = Mono.just("Hello");
        Mono<String> mono2 = Mono.just("World");

        // Use Mono.zip to combine the emissions of both Monos into a single Mono
        Mono<String> zippedMono = Mono.zip(mono1, mono2)
                // Combine the emitted values into a single string
                .map(tuple -> tuple.getT1() + " " + tuple.getT2());

        // Subscribe to the zipped Mono and print the emitted value
        // Hello World
        zippedMono.subscribe(log::info);
    }
}
