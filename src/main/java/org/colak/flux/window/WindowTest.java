package org.colak.flux.window;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 * Windowing operators allow you to segment a Flux into sub-Fluxes based on size or time.
 */
@Slf4j
class WindowTest {

    public static void main() {
        Flux.range(1, 10)
                .window(3)
                .subscribe(subFlux -> {
                    // Process each sub-Flux
                    subFlux.subscribe(value -> log.info(value.toString()));
                });
    }
}
