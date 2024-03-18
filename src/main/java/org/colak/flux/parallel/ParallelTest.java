package org.colak.flux.parallel;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

class ParallelTest {
    public static void main(String[] args) {
        // Create a Flux emitting integers from 1 to 10
        Flux<Integer> sourceFlux = Flux.range(1, 10);

        // Use parallel operator to process elements in parallel
        Flux<Integer> parallelFlux = sourceFlux.parallel()
                // Specify the number of parallel threads
                .runOn(Schedulers.parallel(), Runtime.getRuntime().availableProcessors())
                // Apply a transformation to each element (e.g., multiply by 2)
                .map(integer -> integer * 2)
                // Convert back to a sequential Flux
                .sequential();

        // Subscribe to the parallelFlux and print the emitted elements
        parallelFlux.subscribe(System.out::println);
    }
}
