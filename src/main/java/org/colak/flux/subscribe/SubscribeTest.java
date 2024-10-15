package org.colak.flux.subscribe;

import reactor.core.publisher.Flux;

class SubscribeTest {

    public static void main(String[] args) {

        Flux<Integer> flux = Flux.range(1, 5);

        flux.subscribe(
                data -> System.out.println("Received: " + data + " on thread: " + Thread.currentThread().getName()),
                err -> System.err.println("Error: " + err),
                () -> System.out.println("Completed on thread: " + Thread.currentThread().getName())
        );
    }
}
