package org.colak.flux.flatmap;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

import java.util.function.Function;

class FlatMapTest {

    public static void main() {
        Function<String, Publisher<String>> toUpperCaseFunction = s -> Flux.just(s.toUpperCase().split(""));
        Flux<String> threeMusketeersFlux = Flux.just("Athos", "Porthos", "Aramis");
        Flux<String> outputFlux = threeMusketeersFlux.flatMap(toUpperCaseFunction);
        outputFlux.subscribe(System.out::println);
    }
}
