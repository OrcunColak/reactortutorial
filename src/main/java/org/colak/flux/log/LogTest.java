package org.colak.flux.log;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
class LogTest {

    public static void main() {
        Flux<String> debuggedFlux = Flux.just("A", "B", "C")
                .log();

        debuggedFlux.subscribe(System.out::println);
    }
}
