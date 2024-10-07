package org.colak.mono.zipwhen;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

// Mono.zipWhen is a more flexible variation of zip.
// It allows combining a Mono with another Mono that is dynamically created based on the first Mono’s emitted value.
// Essentially, zipWhen allows you to trigger a second Mono based on the result of the first Mono.
class ZipWhenTest {

    public static void main(String[] args) {
        Mono<String> userMono = Mono.just("John");

        Mono<Tuple2<String, String>> zippedMono = userMono.zipWhen(ZipWhenTest::getUserAddress);

        // John lives at 123 Main St
        zippedMono.subscribe(tuple -> System.out.println(tuple.getT1() + " lives at " + tuple.getT2()));
    }

    // Simulating the getUserAddress method
    public static Mono<String> getUserAddress(String user) {
        return Mono.just("123 Main St");
    }
}
