package org.colak.mono.zipwith;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Combine mono with flux
 */
@Slf4j
class ZipWithTest {

    public static void main(String[] args) {
        // Create a Mono emitting a single value
        Mono<String> mono = Mono.just("MonoValue");

        // Create a Flux emitting multiple values
        Flux<Integer> flux = Flux.range(1, 5);

        // Use zipWith to combine the Mono with the Flux
        Mono<String> combinedFlux = mono.zipWith(flux.collectList(), (monoValue, fluxValue) -> monoValue + " " + fluxValue);

        // Subscribe to the combinedFlux and print the emitted elements
        combinedFlux.subscribe(log::info);
    }
}
