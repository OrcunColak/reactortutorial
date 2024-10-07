package org.colak.mono.zipwith;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

// Mono.zipWith is a shorthand for zipping two Mono instances together.
// It functions similarly to Mono.zip, but instead of being a static method, it’s an instance method that you call on one Mono to zip it with another.

// If any of the combined Monos encounter an error, the resulting Mono will emit an error, making error management straightforward.
class ZipWithTest {

    public static void main(String[] args) {

        Mono<String> mono1 = Mono.just("Spring");
        Mono<String> mono2 = Mono.just("WebFlux");

        Mono<Tuple2<String, String>> zippedMono = mono1.zipWith(mono2);
        // Spring WebFlux
        zippedMono.subscribe(tuple -> System.out.println(tuple.getT1() + " " + tuple.getT2()));
    }
}
