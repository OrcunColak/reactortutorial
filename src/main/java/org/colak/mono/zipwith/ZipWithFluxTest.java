package org.colak.mono.zipwith;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// Mono.zipWith is a shorthand for zipping two Mono instances together.
// It functions similarly to Mono.zip, but instead of being a static method, it’s an instance method that you call on one Mono to zip it with another.
@Slf4j
class ZipWithFluxTest {

    public static void main() {
        // Create a Mono emitting a single value
        Mono<String> mono = Mono.just("MonoValue");

        // Create a Flux emitting multiple values
        Flux<Integer> flux = Flux.range(1, 5);

        // Use zipWith to combine the Mono with the Flux
        Mono<String> combinedFlux = mono.zipWith(flux.collectList(), (monoValue, fluxValue) -> monoValue + " " + fluxValue);

        // Subscribe to the combinedFlux and print the emitted elements
        // MonoValue [1, 2, 3, 4, 5]
        combinedFlux.subscribe(log::info);
    }
}
