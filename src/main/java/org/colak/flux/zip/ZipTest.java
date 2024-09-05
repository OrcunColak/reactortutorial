package org.colak.flux.zip;

import reactor.core.publisher.Flux;

public class ZipTest {

    public static void main(String[] args) {

        zipTwoStreams();
        zipFourStreams();
    }

    private static void zipTwoStreams() {
        Flux<String> abcStream = Flux.just("a", "b", "c");
        Flux<String> defStream = Flux.just("d", "e", "f");
        // the output will be: ad, be, cf
        Flux<String> zippedFlux = Flux.zip(abcStream, defStream, (a, b) -> a + b);

        zippedFlux.subscribe(System.out::println);
    }

    private static void zipFourStreams() {
        Flux<String> one = Flux.just("a", "b", "c");
        Flux<String> two = Flux.just("d", "e", "f");
        Flux<String> three = Flux.just("1", "2", "3");
        Flux<String> four = Flux.just("4", "5", "6");
        // the output will be: ad14, be25, cf36
        Flux<String> zippedFlux =
                Flux.zip(one, two, three, four) // Tuple4 (can be up to Tuple8)
                        .map(t4 -> t4.getT1() + t4.getT2() + t4.getT3() + t4.getT4());
        zippedFlux.subscribe(System.out::println);
    }
}
