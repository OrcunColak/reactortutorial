package org.colak.flux.onerrorcontinue;

import reactor.core.publisher.Flux;

class OnErrorContinueTest {

    public static void main() {

        Flux.just("1", "2", "three", "4", "5")
                .map(Integer::parseInt)
                .onErrorContinue((throwable, o) -> System.out.println("Error parsing: " + o))
                .subscribe(System.out::println);

    }
}
