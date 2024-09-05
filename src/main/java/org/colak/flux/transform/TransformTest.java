package org.colak.flux.transform;

import reactor.core.publisher.Flux;

import java.util.function.Function;

public class TransformTest {

    public static void main(String[] args) {
        Flux<String> threeMusketeersStream = Flux.just("Athos", "Porthos", "Aramis");
        Function<Flux<String>, Flux<String>> filterMap = name -> name.map(String::toUpperCase).filter(s -> s.length() > 5);
        Flux<String> outputFlux = threeMusketeersStream.transform(filterMap);
        outputFlux.subscribe(System.out::println);
    }
}
