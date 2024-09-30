package org.colak.flux.checkpoint;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
class CheckpointTest {

    public static void main(String[] args) {
        Flux<Integer> checkpointedFlux = Flux.just("1", "2", "a", "3")
                .map(Integer::parseInt)
                .checkpoint("Parsing Numbers");

        checkpointedFlux.subscribe(System.out::println, System.err::println);
    }
}
