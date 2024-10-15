package org.colak.flux.subscribeon;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

class SubscribeOnBoundedElastic {

    // All run on boundedElastic
    // Map1: 1 on thread: boundedElastic-1
    // Map2: 1 on thread: boundedElastic-1
    // Received: 1 on thread: boundedElastic-1
    // Map1: 2 on thread: boundedElastic-1
    // Map2: 2 on thread: boundedElastic-1
    // Received: 2 on thread: boundedElastic-1
    // Map1: 3 on thread: boundedElastic-1
    // Map2: 3 on thread: boundedElastic-1
    // Received: 3 on thread: boundedElastic-1
    // Map1: 4 on thread: boundedElastic-1
    // Map2: 4 on thread: boundedElastic-1
    // Received: 4 on thread: boundedElastic-1
    // Map1: 5 on thread: boundedElastic-1
    // Map2: 5 on thread: boundedElastic-1
    // Received: 5 on thread: boundedElastic-1
    public static void main() {
        Flux<Integer> flux = Flux.range(1, 5)
                .map(i -> {
                    System.out.println("Map1: " + i + " on thread: " + Thread.currentThread().getName());
                    return i;
                })
                .subscribeOn(Schedulers.boundedElastic())
                .map(i -> {
                    System.out.println("Map2: " + i + " on thread: " + Thread.currentThread().getName());
                    return i;
                });

        flux.subscribe(
                data -> System.out.println("Received: " + data + " on thread: " + Thread.currentThread().getName())
        );

        // Sleep to see the output
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
