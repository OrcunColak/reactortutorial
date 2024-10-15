package org.colak.flux.concat;

import reactor.core.publisher.Flux;

// Flux.merge and Flux.concat are similar
class ConcatTest {

    public static void main() {
        Flux<String> abcStream = Flux.just("a", "b", "c");
        Flux<String> defStream = Flux.just("d", "e", "f");
        // the output will be: a, b, c, d, e, f
        Flux<String> concattedWithFlux = abcStream.concatWith(defStream);
        concattedWithFlux.subscribe(System.out::println);
    }
}
